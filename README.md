# README #
## Spring OAuth2.0
### AuthorizationServer(권한관리서버)
@EnableAuthorizationServer

This README would normally document whatever steps are necessary to get your application up and running.


# 키 파일 생성 #

1. keytool -genkeypair \
           -alias ktds \
           -keyalg RSA \
           -dname "CN=Auth,OU=,O=ktds,L=Seoul,S=Seoul,C=KR" \
           -keypass new1234! \
           -keystore ktds.jks \
           -storepass new1234!

1. keytool -export -keystore ./ktds.jks -alias ktds -file ktds.cer

1. openssl x509 -inform der -in ./ktds.cer -pubkey -noout



```sh
-----BEGIN PUBLIC KEY-----
MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEArqv+qTH1smdoy8Qusw+U
Cm1I1iu9CbJYMakXIwqLptSbb+9qpoFcs6YjBfPHfkR//OjfSAu1Rq6Baaf5qdxb
eW9mVMiKgheCLTu1V0on8ylVj+S2Xwnkqr8QXaCni0q5/4iginbgsPzitU7i0aGP
Ocs+xLJhxcgHxi2VfK1iPMBjXzYGoca/Aj7sEVt4bS0rxqjn/j7p9+5rf4dYL3tN
v4afUQTVDVAjTE1X2fCblOhau6jIs7xlD1NsHrNu1WKuUaVJiPItxyTxJFx9nqG2
25IpQOrJCPx8S9aLlNaaRhX5xFggsWVCYnoJ9l8QMB7S0jb+Aub3sZcMWA8lWQ8W
lQIDAQAB
-----END PUBLIC KEY-----
```


# 키생성 