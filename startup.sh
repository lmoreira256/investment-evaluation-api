#!/bin/bash
cd /home/ubuntu
aws s3 cp s3://investment-evaluation/investment-evaluation-server-0.0.1-SNAPSHOT.jar .
java -jar investment-evaluation-server-0.0.1-SNAPSHOT.jar