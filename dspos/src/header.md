## <span id="api-example-for-a-submenu-purpose">文档目的</span>
本文档定义了东升智慧园区项目POS平台服务与POS客户端接口规范，供产品人员、平台及客户端开发人员参考。

## <span id="api-example-for-a-submenu-entry-interface">通讯方式</span>
承载协议：HTTP(S) POST;
<br/>
编码格式：采用UTF-8编码;

## <span id="api-example-for-a-submenu-entry-data">数据类型</span>
本类型接口命令与响应报文格式中各参数类型定义遵照下表说明：

| 数据类型       | 描述           |
| ------------- |:--------------:|
| String        | 字符串          |
| Number        | 数字            |
| Boolean       | 布尔值          |
| Hex           | 16进制字符串    |
| Object        | 对象            |
| Object[] | 数组 |

## <span id="api-example-for-a-submenu-entry-header">请求头</span>
| 字段名称    | 类型           |说明           |
| ------------- |:--------------:|:--------------:|
|baseInfo  | String |参见下面参数定义|
|sign | String |签名（body中的参数RSA加密）,服务端生成公私钥对，客户端使用私钥对Body进行签名，服务端对签名进行验签，来验证请求方的身份消息以及消息是否被篡改。其密钥长度：2048，签名算法：SHA256withRSA。|
|token | String |登录Token,签退后失效，或设定有效期后失效，如1天|

## <span id="api-example-for-a-submenu-entry-basereq">请求头 BaseInfo 参数</span>
| 字段名称    | 类型           |必须           |说明           |
| ------------- |:--------------:|:--------------:|:--------------:|
|deviceName | String |M |设备名称  |
|deviceModel	|String	|M	|设备型号|
|deviceOsVersion	|String	|M	|手机系统版本号|
|posSn	|String	|M	|设备SN号|
|posEn	|String	|M	|设备EN号|
|mcode	|String	|M	|店铺Mcode|
|clientAppHash	|String	|O	|客服端哈希值，android必传|
|clientAppId	|String	|M	|客户端包名|
|clientVersion	|String	|M	|客户端版本|

## <span id="api-example-for-a-submenu-entry-baseresp">公共响应信息</span>

| 字段名称    | 描述           |
| ------------- |:--------------:|
| status |状态码 |
| desc |响应描述 |
| timeStamp |服务器时间 yyyyMMddHHmmss |

