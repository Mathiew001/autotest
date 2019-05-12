#!/usr/local/bin/python
# -*- coding:utf-8 -*-

import sys
import os

env = {
	"ci": {
		"test_env": "ci",
		"http_url": "http://115.238.125.85:4444",
		"http_admin": "http://115.238.125.85:4445",
		"http_url_ingress": "http://115.238.125.85:1414",
		"http_admin_ingress": "http://115.238.125.85:1415",
		"http_line": "normal",
		"check_db": "false",
		"import_db": "false"
	},
	"pre_yq_pub": {
	    "test_env": "pre_yq_pub",
        "http_url": "http://10.176.59.113:8080",
        "http_admin": "http://10.176.59.113:8080",
        "http_url_ingress": "http://10.176.59.113:8888",
        "http_admin_ingress": "http://10.176.59.113:8888",
        "http_line": "normal",
        "check_db": "false",
        "import_db": "false"
	},
	"online_yq_pub": {
        "test_env": "online_yq_pub",
        "http_url": "http://10.176.95.241:8080",
        "http_admin": "http://10.176.95.241:8083",
        "http_url_ingress": "http://10.176.95.241:8888",
        "http_admin_ingress": "http://10.176.95.241:8889",
        "http_line": "normal",
        "check_db": "false",
        "import_db": "false"
	},
	"pre_lt_pub": {
        "test_env": "pre_liantong_pub",
        "http_url": "http://10.192.138.84:8080",
        "http_admin": "http://10.192.138.84:8080",
        "http_url_ingress": "http://10.192.138.84:8888",
        "http_admin_ingress": "http://10.192.138.84:8888",
        "http_line": "normal",
        "check_db": "false",
        "import_db": "false"
	},
	"online_lt_pub": {
        "test_env": "online_lt_pub",
        "http_url": "http://10.192.128.251:8080",
        "http_admin": "http://10.192.128.251:8083",
        "http_url_ingress": "http://10.192.128.251:8888",
        "http_admin_ingress": "http://10.192.128.251:8889",
        "http_line": "normal",
        "check_db": "false",
        "import_db": "false"
	},
	"pre_jd_pub": {
        "test_env": "pre_jd_pub",
        "http_url": "http://10.195.1.53:8080",
        "http_admin": "http://10.195.1.53:8080",
        "http_url_ingress": "http://10.195.1.53:8888",
        "http_admin_ingress": "http://10.195.1.53:8888",
        "http_line": "normal",
        "check_db": "false",
        "import_db": "false"
	},
	"online_jd_pub": {
        "test_env": "pre_jd_pub",
        "http_url": "http://10.195.0.251:8080",
        "http_admin": "http://10.195.0.251:8083",
        "http_url_ingress": "http://10.195.0.251:8888",
        "http_admin_ingress": "http://10.195.0.251:8889",
        "http_line": "normal",
        "check_db": "false",
        "import_db": "false"
	},
	"pre_jd_pri": {
        "test_env": "pre_jd_pri",
        "http_url": "http://10.194.1.111:8080",
        "http_admin": "http://10.194.1.111:8080",
        "http_url_ingress": "http://10.194.1.111:8888",
        "http_admin_ingress": "http://10.194.1.111:8888",
        "http_line": "normal",
        "check_db": "false",
        "import_db": "false"
	},
	"online_jd_pri": {
        "test_env": "pre_jd_pri",
        "http_url": "http://10.194.0.251:8080",
        "http_admin": "http://10.194.0.251:8083",
        "http_url_ingress": "http://10.194.0.251:8888",
        "http_admin_ingress": "http://10.194.0.251:8889",
        "http_line": "normal",
        "check_db": "false",
        "import_db": "false"
	}

}

config_path = "src/test/resources/conf/test-config.properties"

if __name__ == "__main__":
    e = sys.argv[1]
    if e not in env.keys(): 
        sys.exit(1)
    for key, value in env[e].items():
        with open(config_path, 'a') as f:
            f.write(key + '=' + value + '\n')
    