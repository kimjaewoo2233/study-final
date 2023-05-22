#!/bin/bash
BUILD_JAR=$(ls /home/ubuntu/deploy/deploy/*.jar)
nohup java -jar "$BUILD_JAR" >> /home/ubuntu/deploy_test.log 2>/home/ubuntu/action/deploy_err_test.log &
