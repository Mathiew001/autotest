各环境命令：
测试环境：mvn test -Dxml.file=ci
东冠私有云线上：mvn test -Dxml.file=online-dg-pri
东冠公有云线上：mvn test -Dxml.file=online-dg-pub
建德私有云线上：mvn test -Dxml.file=online-jd-pri
建德公有云线上：mvn test -Dxml.file=online-jd-pub
联通私有云线上：mvn test -Dxml.file=online-lt-pri
联通公有云线上：mvn test -Dxml.file=online-lt-pub
义桥公有云线上：mvn test -Dxml.file=online-yq-pub