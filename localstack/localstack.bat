@echo off
echo ### Configurando profile localstack
echo ### aws configure
echo ### aws configure --profile localstack
echo ### Criando Chaves no AWS Parameter Store do LocalStack...
aws --endpoint http://localhost:4566 --profile localstack ssm put-parameter --name "/config/sboot-localstack_localstack/helloWorld" --value "Hello World Parameter Store" --type String