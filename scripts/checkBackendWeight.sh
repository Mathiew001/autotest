#!/bin/bash

file=result
if [ -f "$file" ]
then
	rm $file
fi

ip=$1
port=$2
protocol=$3
host=$4
url=$5

start=$(date +%s) 

while true
do
	sh curlVip.sh $ip $port $protocol $host $url >> result 2>&1 &
	echo "\n" >> result
	end=$(date +%s)
	if [ $(( $end - $start )) = 60 ]
	then
		break
	fi
done

num1=`grep qainstance1 result | wc -l`
num2=`grep qainstance2 result | wc -l`

result1=0
result2=0
if [ $num1 -gt $num2 ]
then
	result1=$num1
	result2=$num2
else
	result2=$num1
	result1=$num2
fi
	
result=$(printf "%.2f" `echo "scale=2;$result1/$result2" | bc`)
echo $result
