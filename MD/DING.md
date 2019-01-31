# 钉钉扫码登录
 - https://open-doc.dingtalk.com/microapp/serverapi2/kymkv6
<code>百度钉钉开发平台，进入扫码登录第三方Web网站</code>
 - 注册一个企业帐号
 - 根据appId和appSecret调接口
### 第一种是通过接入钉钉的二维码登录
 > 访问https://oapi.dingtalk.com/connect/qrconnect?appid=APPID&response_type=code&scope=snsapi_login&state=STATE&redirect_uri=REDIRECT_URI
替换APPID，REDIRECT_URI，其他都是固定的，可不动
扫码后会跳转到REDIRECT_URI这个链接地址

### 第二种是通过内嵌一个二维码到你系统
 [index.jsp](https://github.com/gpnine/JAVAWeb-Advanced/edit/master/zcl-webapp/src/main/webapp/index.jsp)
 - 通过[oauth2](https://www.cnblogs.com/flashsun/p/7424071.html)/sns_authorize这个接口跳转，跳转后会拼接一个code（跳转的地址输对了）
 - post请求添加参数{"tmp_auth_code":code}
 - 请求后会返回用户信息

| 参数 | 说明 |
| :--------: | :--------: |
| nick | 用户在钉钉上面的昵称 |
| openid | 用户在当前开放应用内的唯一标识 |
| unionid | 用户在当前开放应用所属企业的唯一标识 |

