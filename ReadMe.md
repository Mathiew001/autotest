nlb自动化脚本使用说明


1. git clone ssh://git@g.hz.netease.com:22222/CloudQA/nlb-api-test.git    #拉取源代码

2. cd nlb-api-test/src/test/resources/conf  #进入配置文件目录

3. 在该目录下，test-config.properties为环境信息配置文件，配置说明如下：

    1）test_env  #测试环境，私有化请填写private
    
    2）http_url  #nlb-server节点url，例如http://115.238.125.103:8080
    
    3）http_url_ingress  #nlb-translator节点url，例如http://115.238.125.103:8888
    
    4）http_line  #网关模式/正常模式，私有化请填写normal

4. cd private，private目录下的ext.conf为生成yaml测试数据的配置文件，只需配置该文件即可，配置说明如下：

    1）tenant_id #租户id

    2) vpc_id  #Vpc id，手动创建
    
    3) region  #环境region, 例如netease-pricloud-1
    
    4) topaz  #环境Topaz，例如netease-pricloud-1a
    
    5) subnet_id  #vpc_id下对应的子网id，手动创建
    
    6) security_group1  #安全组id，手动创建并添加入网全流量规则
    
    7) security_group2  #安全组id，创建vpc后的default安全组
    
    8) security_group_default  #安全组id，默认的服务安全组

    9) real_server1_vpc  #云服务器1，手动创建，登陆机器，执行curl http://nos.netease.com/omad/installNode.sh|bash，启动后端服务
    
    10) real_server2_vpc  #云服务器2，手动创建，登陆机器，执行curl http://nos.netease.com/omad/installNode.sh|bash，启动后端服务
    
    11) rs_name1_vpc  #云服务器1名字，手动创建的云服务器1的名字，后端关联一个deployment，登陆副本执行curl http://nos.netease.com/omad/installNode.sh|bash
    
    12) rs_name2_vpc  #云服务器2名字，手动创建的云服务器2的名字，后端关联一个deployment，登陆副本执行curl http://nos.netease.com/omad/installNode.sh|bash
    
    13) rs_address1_vpc  #云服务器1的ip，手动创建的云服务器1的ip
    
    14) rs_address2_vpc  #云服务器2的ip，手动创建的云服务器2的ip

    15) namespace  #容器服务的名字空间，手动创建
    
    16) service_name1_vpc  #对应namespace下的容器服务中的服务与发现名字1，手动创建
    
    17) service_name2_vpc  #对应namespace下的容器服务中的服务与发现名字2，手动创建
    
    18) security_group_default_ingress  #安全组id，默认的ingress服务安全组

    19) cert_id  #https证书id，手动创建，同步到nlb分库中
    
    20) cipher_suite_id  #任意一个安全套件id
    
5. cd /nlb-api-test

6. mvn test -Dxml.file=private-nlb  #运行nlb测试脚本

7. mvn test -Dxml.file=private-ingress  #运行ingress测试脚本
