### Command for generating keystore file using java keytool

- Generate keystore command
```shell
> keytool -genkeypair -alias demo_keystore -keyalg RSA -keysize 2048 -validity 365 -storetype PKCS12 -keystore C:\user\file\demo.keystore -storepass changeit -dname "CN=localhost, OU=Development, O=DemoOrganization, L=Malaysia, ST=KualaLumpur, C=MY" -ext SAN=DNS:localhost,IP:127.0.0.1
```
- List all the key and certificates inside the keystore command(with password)
```shell
> keytool -list -keystore C:\user\file\demo.keystore -storepass changeit -v
```
- Output public certificate command from keystore to be in plain text format
```shell
> keytool -exportcert -alias demo_keystore -keystore C:\user\file\demo.keystore -storepass changeit -storetype PKCS12 -file C:\user\file\demo.crt -rfc
```
- Export keystore to pem file(would need openssl installed)
```shell
> keytool -importkeystore -srckeystore C:\user\file\demo.keystore -srcstorepass changeit -destkeystore C:\user\file\dest.keystore -deststoretype PKCS12 -deststorepass changeit -srcalias demo_keystore

> openssl pkcs12 -in C:\user\file\dest.keystore -out C:\user\file\final.pem -nodes
```
- Generate private key using openssl(Please execute terminal "Run as administrator" if on Windows or using sudo command to execute the command)
```shell
> openssl pkey -in C:\user\file\final.pem -out C:\user\file\test_private.key
```
- Generate public cert using openssl
```shell
> openssl x509 -in C:\user\file\final.pem -out C:\user\file\test_public.crt
```
- Import key and cert into keystore
```shell
> openssl pkcs12 -export -in C:\user\file\test_public.crt -inkey C:\user\file\test_private.key -out C:\user\file\bundled.p12
# after output the p12 file, then add it into the keystore, check the keystore alias name before add it into another keystore
> keytool -list -keystore C:\user\file\demo.keystore -storepass changeit -v
# import the keystore into another keystore 
> keytool -importkeystore -srckeystore C:\user\file\bundled.p12 -destkeystore C:\user\file\demo.keystore -deststoretype PKCS12 -srcalias 1 -destalias test_keystore
```
- Remove keystore entry with alias name
```shell
> keytool -delete -alias test_keystore -keystore C:\user\file\demo.keystore -storetype PKCS12 -storepass changeit
```