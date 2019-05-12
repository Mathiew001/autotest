#~/bin/bash

ip=$1
port=$2
host=$4
url=$5
protocol=$3

if [ "$protocol" = "http" ]
then
	curl http://$ip:$port$url -H "host: $host" 
elif [ "$protocol" = "https" ]
then
	curl https://$ip:$port$url -H "host: $host" -k
elif [ "$protocol" = "tls" ]
then
	curl https://$ip:$port$url -k
elif [ "$protocol" = "tcp" ]
then
	curl $ip:$port
else
	echo "invalid protocol"
fi
