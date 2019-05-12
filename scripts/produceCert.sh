#!/usr/bin/env bash
rm -f ssl.crt  ssl.csr  ssl.key
echo "--------"
expect -c "
    spawn openssl genrsa -des3 -out ssl.key 2048
    expect {
    \"Enter pass phrase for ssl.key\" { send \"nimeide\n\"; exp_continue}
    \"Verifying - Enter pass phrase for ssl.key\" { send \"nimeide\n\"; exp_continue}
    \"Enter pass phrase for xxx.key:\" { send \"nimeide\n\"; exp_continue}
    }
"
mv ssl.key xxx.key
expect -c "
    spawn openssl rsa -in xxx.key -out ssl.key
    expect {
    \"Enter pass phrase for ssl.key\" { send \"nimeide\n\"; exp_continue}
    \"Verifying - Enter pass phrase for ssl.key\" { send \"nimeide\n\"; exp_continue}
    \"Enter pass phrase for xxx.key:\" { send \"nimeide\n\"; exp_continue}
    }
"
rm xxx.key
echo "hi2"
expect -c "
    spawn openssl req -new -key ssl.key -out ssl.csr
    expect {
    \"Country Name\" { send \"CN\n\"; exp_continue}
    \"Province Name\" { send \"SD\n\"; exp_continue}
    \"Locality Name\" { send \"hz\n\"; exp_continue}
    \"Organization Name\" { send \"netexxx\n\"; exp_continue}
    \"Organizational Unit Name\" { send \"testaa\n\"; exp_continue}
    \"Common Name\" { send \"woyun\n\"; exp_continue}
    \"Email Address\" { send \"common@net.com\n\"; exp_continue}
    \"A challenge password\" { send \"abcdxxxcomsa\n\"; exp_continue}
    \"An optional company name\" { send \"caibuchulaile\n\"; exp_continue}
    }
"
openssl x509 -req -days 3650 -in ssl.csr -signkey ssl.key -out ssl.crt
