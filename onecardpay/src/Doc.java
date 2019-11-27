//定义组别
/**
* @apiDefine OneCardPay 一卡通收银台SDK
*/
	
//通用报文定义
	
//接口定义

/**
 * @api {POST} oneCardPay/orderInfo 订单信息查询
 * @apiVersion 1.0.0
 * @apiName orderInfo
 * @apiGroup OneCardPay
 * @apiDescription 订单信息查询
 * @apiParam {String} userId 用户标识
 * @apiParam {String} phoneNumber 用户手机号，通过 AES 加密。 
 * @apiParam {String} orderId 订单号
 * @apiSuccess {String} merchantName 商户名称
 * @apiSuccess {String} productName 商品名称
 * @apiSuccess {Number} totalOrderPrice 订单总价，单位：分。
 * @apiSuccess {Number} feeOfOutOfPacket 实付金额，单位：分。
 * @apiSuccess {Number} feeOfDiscount 优惠金额，单位：分。
*/

/**
 * @api {POST} oneCardPay/accountList 账户列表
 * @apiVersion 1.0.0
 * @apiName accountList
 * @apiGroup OneCardPay
 * @apiDescription 账户列表
 * @apiParam {String} userId 用户标识
 * @apiParam {String} phoneNumber 用户手机号，通过 AES 加密。 
 * @apiSuccess {Object[]} accounts 支付账户列表 
 * @apiSuccess {String} accounts.name 账户名称，目前就两个，账户余额，企业账户。
 * @apiSuccess {String} accounts.type 账户类型
 * - 1：账户余额
 * - 2：企业账户
*/

/**
 * @api {POST} oneCardPay/payOrder 订单支付
 * @apiVersion 1.0.0
 * @apiName payOrder
 * @apiGroup OneCardPay
 * @apiDescription 订单支付
 * @apiParam {String} userId 用户标识
 * @apiParam {String} phoneNumber 用户手机号，通过 AES 加密。
 * @apiParam {String} orderId 订单编号
 * @apiParam {String} pwd 支付密码，SHA256加密。
 * @apiParam {String} payChannel 支付方式
 * - 1：账户余额
 * - 2：企业账户
 * @apiSuccess {String} payChannel 支付方式
 * - 1：账户余额
 * - 2：企业账户
 * @apiSuccess {String} productName 商品名称
 * @apiSuccess {String} orderAmount 订单金额 
 * @apiSuccess {String} orderId 订单号
 * @apiSuccess {String} payTime 支付时间，格式 yyyyMMddHHmmss。
*/

/**
 * @api {POST} oneCardPay/payOrderForH5 H5订单支付
 * @apiVersion 1.0.0
 * @apiName payOrderForH5
 * @apiGroup OneCardPay
 * @apiDescription H5订单支付
 * @apiParam {String} userId 用户标识
 * @apiParam {String} phoneNumber 用户手机号，通过 AES 加密。
 * @apiParam {String} orderId 订单编号
 * @apiParam {String} pwd 支付密码，SHA256加密。
 * @apiParam {String} payChannel 支付方式
 * - 1：账户余额
 * - 2：企业账户
 * @apiParam {String} tradeInfo 支付安全参数
 * @apiSuccess {String} payChannel 支付方式
 * - 1：账户余额
 * - 2：企业账户
 * @apiSuccess {String} productName 商品名称
 * @apiSuccess {String} orderAmount 订单金额 
 * @apiSuccess {String} orderId 订单号
 * @apiSuccess {String} payTime 支付时间，格式 yyyyMMddHHmmss。
*/



