define({  "name": "阿里东升智慧园区项目",  "version": "1.0.0",  "description": "阿里东升智慧园区服务端与收银台客户端SDK接口规范",  "title": "阿里东升智慧园区接口规范",  "url": "http://ip:port/pay/",  "header": {    "title": "平台概述111111",    "content": "<h2><span id=\"api-example-for-a-submenu-purpose\">文档目的</span></h2>\n<p>111本文档定义了阿里东升智慧园区平台与收银台客户端SDK接口规范，供产品人员、平台及客户端开发人员参考。</p>\n<h2><span id=\"api-example-for-a-submenu-entry-interface\">通讯方式</span></h2>\n<p>承载协议：HTTP(S) POST;\n<br/>\n编码格式：采用UTF-8编码;</p>\n<h2><span id=\"api-example-for-a-submenu-entry-data\">数据类型</span></h2>\n<p>本类型接口命令与响应报文格式中各参数类型定义遵照下表说明：</p>\n<table>\n<thead>\n<tr>\n<th>数据类型</th>\n<th style=\"text-align:center\">描述</th>\n</tr>\n</thead>\n<tbody>\n<tr>\n<td>String</td>\n<td style=\"text-align:center\">字符串</td>\n</tr>\n<tr>\n<td>Number</td>\n<td style=\"text-align:center\">数字</td>\n</tr>\n<tr>\n<td>Boolean</td>\n<td style=\"text-align:center\">布尔值</td>\n</tr>\n<tr>\n<td>Hex</td>\n<td style=\"text-align:center\">16进制字符串</td>\n</tr>\n<tr>\n<td>Object</td>\n<td style=\"text-align:center\">对象</td>\n</tr>\n<tr>\n<td>Object[]</td>\n<td style=\"text-align:center\">数组</td>\n</tr>\n</tbody>\n</table>\n<h2><span id=\"api-example-for-a-submenu-entry-header\">请求头</span></h2>\n<table>\n<thead>\n<tr>\n<th>字段名称</th>\n<th style=\"text-align:center\">类型</th>\n<th style=\"text-align:center\">说明</th>\n</tr>\n</thead>\n<tbody>\n<tr>\n<td>baseInfo</td>\n<td style=\"text-align:center\">String</td>\n<td style=\"text-align:center\">参见下面参数定义</td>\n</tr>\n<tr>\n<td>sign</td>\n<td style=\"text-align:center\">String</td>\n<td style=\"text-align:center\">签名（body中的参数RSA加密）</td>\n</tr>\n</tbody>\n</table>\n<h2><span id=\"api-example-for-a-submenu-entry-basereq\">请求头 BaseInfo 参数</span></h2>\n<table>\n<thead>\n<tr>\n<th>字段名称</th>\n<th style=\"text-align:center\">类型</th>\n<th style=\"text-align:center\">必须</th>\n<th style=\"text-align:center\">说明</th>\n</tr>\n</thead>\n<tbody>\n<tr>\n<td>deviceModel</td>\n<td style=\"text-align:center\">String</td>\n<td style=\"text-align:center\">M</td>\n<td style=\"text-align:center\">设备型号</td>\n</tr>\n<tr>\n<td>deviceOsVersion</td>\n<td style=\"text-align:center\">String</td>\n<td style=\"text-align:center\">M</td>\n<td style=\"text-align:center\">手机系统版本号</td>\n</tr>\n<tr>\n<td>deviceType</td>\n<td style=\"text-align:center\">int</td>\n<td style=\"text-align:center\">M</td>\n<td style=\"text-align:center\">设备类型 1:android 2:IOS</td>\n</tr>\n<tr>\n<td>clientAppHash</td>\n<td style=\"text-align:center\">String</td>\n<td style=\"text-align:center\">O</td>\n<td style=\"text-align:center\">客服端哈希值，android必传</td>\n</tr>\n<tr>\n<td>clientAppId</td>\n<td style=\"text-align:center\">String</td>\n<td style=\"text-align:center\">M</td>\n<td style=\"text-align:center\">客户端包名</td>\n</tr>\n<tr>\n<td>clientVersion</td>\n<td style=\"text-align:center\">String</td>\n<td style=\"text-align:center\">M</td>\n<td style=\"text-align:center\">客户端版本</td>\n</tr>\n</tbody>\n</table>\n<h2><span id=\"api-example-for-a-submenu-entry-baseresp\">签名规则</span></h2>\n<p>服务端生成公私钥对，客户端使用私钥对Body进行签名，服务端对签名进行验签，来验证请求方的身份消息以及消息是否被篡改。其密钥长度：2048，签名算法：SHA256withRSA。</p>\n<h2><span id=\"api-example-for-a-submenu-entry-baseresp\">公共响应信息</span></h2>\n<table>\n<thead>\n<tr>\n<th>字段名称</th>\n<th style=\"text-align:center\">描述</th>\n</tr>\n</thead>\n<tbody>\n<tr>\n<td>status</td>\n<td style=\"text-align:center\">状态码</td>\n</tr>\n<tr>\n<td>desc</td>\n<td style=\"text-align:center\">响应描述</td>\n</tr>\n</tbody>\n</table>\n"  },  "footer": {    "title": "附录",    "content": "<h2><span id=\"api-example-for-a-submenu-code\">状态码</span></h2>\n<table>\n<thead>\n<tr>\n<th>状态码</th>\n<th style=\"text-align:center\">描述</th>\n</tr>\n</thead>\n<tbody>\n<tr>\n<td>0</td>\n<td style=\"text-align:center\">成功</td>\n</tr>\n<tr>\n<td>1000</td>\n<td style=\"text-align:center\">操作失败</td>\n</tr>\n<tr>\n<td>1001</td>\n<td style=\"text-align:center\">签名错误</td>\n</tr>\n<tr>\n<td>1002</td>\n<td style=\"text-align:center\">参数错误</td>\n</tr>\n<tr>\n<td>1003</td>\n<td style=\"text-align:center\">权限错误（appId和签名值校验）</td>\n</tr>\n<tr>\n<td>9999</td>\n<td style=\"text-align:center\">服务器异常</td>\n</tr>\n</tbody>\n</table>\n"  },  "order": [    "orderInfo",    "accountList",    "payOrder",    "payOrderForH5"  ],  "sampleUrl": false,  "defaultVersion": "0.0.0",  "apidoc": "0.3.0",  "generator": {    "name": "apidoc",    "time": "2019-11-27T06:42:30.377Z",    "url": "http://apidocjs.com",    "version": "0.17.7"  }});
