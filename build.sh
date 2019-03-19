#!/usr/bin/env bash

mvn clean package -Dmaven.test.skip=true -U

docker build -t iridescent/order .

docker push ccr.ccs.tencentyun.com/iridescent/order:0.0.1

