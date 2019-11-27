//定义组别
/**
* @apiDefine BaseGroup 接口定义
*/

	
	
	
//通用报文定义

/**
* @apiDefine BaseResponse 基础响应信息
* @apiSuccess {Number} status 状态码
* @apiSuccess {String} desc 状态描述
* @apiSuccess {String} timeStamp 服务器时间 yyyyMMddHHmmss
*/

/**
* @apiDefine BaseRequest 基础请求信息
* @apiParam {String} operatorNo 操作员编号
*/
	
//接口定义	
/**
 * @api {POST} operator/signIn 签到
 * @apiVersion 1.0.0
 * @apiName signIn
 * @apiGroup BaseGroup
 * @apiDescription 签到，签到成功后客户端定时发起心跳请求
 * @apiParam {String} loginInfo 登录信息加密字符串（AES加密），明文JSON格式见下定义
 * @apiParam {String} loginInfo.operatorNo 操作员登录账号
 * @apiParam {String} loginInfo.loginPwd 操作员登录密码（SHA256加密）
 * @apiParam {String} loginInfo.posSn 设备编号
 * @apiUse BaseResponse
 * @apiSuccess {String} token 用户登录Token
 * @apiSuccess {String} merchantNo 商户编号
 * @apiSuccess {String} merchantName 商户名称
 * @apiSuccess {String} operatorNo 操作员编号
 * @apiSuccess {String} operatorName 操作员姓名
 * @apiSuccess {Int} payLimitAmount 小额免密支付限额
 */
 
 
/**
 * @api {POST} operator/signOut 签退
 * @apiVersion 1.0.0
 * @apiName signOut
 * @apiGroup BaseGroup
 * @apiDescription 签退,签退成功后客户端停止心跳发送
 * @apiUse BaseRequest
 * @apiUse BaseResponse
 */
 
 
 /**
 * @api {POST} operator/couponVerify 券码验证
 * @apiVersion 1.0.0
 * @apiName couponVerify
 * @apiGroup BaseGroup
 * @apiDescription 券码验证,券码有效返回成功，无效返回失败
 * @apiParam {Int} amount 收款金额，分
 * @apiParam {String} coupon 券码
 * @apiUse BaseRequest
 * @apiUse BaseResponse
 * @apiSuccess {String} couponNo 优惠券编号
 * @apiSuccess {Number} couponAmt 优惠金额
 * @apiSuccess {String} couponMsg 优惠券信息
 * @apiSuccess {String} couponMsg 优惠券信息
 */
 
 
  /**
 * @api {POST} operator/accountVerify 账户校验
 * @apiVersion 1.0.0
 * @apiName accountVerify
 * @apiGroup BaseGroup
 * @apiDescription 账户校验,判断是否满足消费条件（消费金额<在线账户余额、状态正常）、卡片状态正常、非黑名单用户
 * @apiParam {String} cardType 卡类型
 * - 1:新卡
 * - 2:旧卡
 * @apiParam {String} cardNo 用户卡号,新卡为卡号，旧卡为UID
 * @apiParam {Int} amount 支付金额
 * @apiParam {Int} offlineBalance 脱机信用额（透支限额-已透支金额）
 * @apiParam {String} [coupon] 券码,当用户使用券码时，账户校验余额的判断，应以优惠后的消费金额为准
 * @apiUse BaseRequest
 * @apiUse BaseResponse
 * @apiSuccess {Object[]} apdus 风控APDU集合
 * @apiSuccess {String} apdus.index APDU索引
 * @apiSuccess {String} apdus.apdu APDU指令
 * @apiSuccess {String} apdus.sw 期望状态字，多个以”|“隔开
 */
 
 
 /**
 * @api {POST} operator/uploadTrade 上传交易记录
 * @apiVersion 1.0.0
 * @apiName uploadTrade
 * @apiGroup BaseGroup
 * @apiDescription 上传交易记录（一般用于联机消费记录上传），后台需判断支付密码是否正确，如果有优惠券，还需计算优惠券优惠金额
 * @apiParam {String} [accountPayPwd] 账户支付密码（SHA256加密），当支付金额大于小额免密支付限额，客户端请求
 * @apiParam {String} cashier 收银员编号(用于区分实际收银的人和上传交易的人)
 * @apiParam {String} cardNo 用户卡号
 * @apiParam {String} tradeNo 交易序号
 * @apiParam {Int} amount 原收款金额,分
 * @apiParam {String} tradeDate 交易日期，yyyyMMdd
 * @apiParam {String} tradeTime 交易时间，HHmmss
 * @apiParam {String} posNo 终端POS编号
 * @apiParam {String} tradeType 交易类型
 * - 1:联机消费
 * - 2:脱机消费
 * @apiParam {String} tac 交易验证码（Transaction Authorization Cryptogram）
 * @apiParam {String} mac 报文认证码(Message Authentication Code)
 * @apiParam {String} [coupon] 券码，仅联机消费可用
 * @apiParam {String} [tradeRecord] 卡内交易信息，可能为空
 * @apiUse BaseRequest
 * @apiUse BaseResponse
 * @apiSuccess {String} tradeId 交易ID
 * @apiSuccess {Int} amount 原收款金额,分
 * @apiSuccess {String} realCardNo 卡面号（老卡有值，新卡为空。）
 * @apiSuccess {Int} actualAmount 实际收款金额,分
 * @apiSuccess {Int} accountAmount 账户扣款，分
 * @apiSuccess {Int} subsidyAmount 补贴扣款，分
 * @apiSuccess {Int} couponAmount 优惠券,分
 * @apiSuccess {Int} memberAmount 会员折扣金额,分
 * @apiSuccess {Int} accountBalanceBefore 收款前账户余额,分
 * @apiSuccess {Int} accountBalanceAfter 收款后账户余额,分
 */
 
 
/**
 * @api {POST} operator/uploadTradeList 批量上传交易记录
 * @apiVersion 1.0.0
 * @apiName uploadTradeList
 * @apiGroup BaseGroup
 * @apiDescription 批量上传交易记录（一般用于脱机消费记录上传）
 * @apiParam {Object[]} tradeList 交易记录列表
 * @apiParam {String} tradeList.cashier 收银员编号(用于区分实际收银的人和上传交易的人)
 * @apiParam {String} tradeList.cardNo 用户卡号
 * @apiParam {String} tradeList.tradeNo 交易序号
 * @apiParam {Int} tradeList.amount 原收款金额,分
 * @apiParam {String} tradeList.tradeDate 交易日期，yyyyMMdd
 * @apiParam {String} tradeList.tradeTime 交易时间，HHmmss
 * @apiParam {String} tradeList.posNo 终端POS编号
 * @apiParam {String} tradeList.tradeType 交易类型
 * - 1:联机消费
 * - 2:脱机消费
 * @apiParam {String} tradeList.tac 交易验证码（Transaction Authorization Cryptogram）
 * @apiParam {String} tradeList.mac 报文认证码(Message Authentication Code)
 * @apiParam {String} [tradeList.coupon] 券码，仅联机消费可用
 * @apiParam {String} [tradeList.tradeRecord] 卡内交易信息，可能为空
 * @apiUse BaseRequest
 * @apiUse BaseResponse
 */
 
 
 
  /**
 * @api {POST} operator/accountBalance 账户余额查询
 * @apiVersion 1.0.0
 * @apiName accountBalance
 * @apiGroup BaseGroup
 * @apiDescription 卡余额查询
 * @apiParam {String} cardType 卡类型
 * - 1:新卡
 * - 2:旧卡
 * @apiParam {String} cardNo 用户卡号,新卡为卡号，旧卡为UID
 * @apiUse BaseRequest
 * @apiUse BaseResponse
 * @apiSuccess {Int} accountBalance 用户账户总资产，分,主卡为账户余额，副卡和公司卡为当前额度
 * @apiSuccess {String} cardMemberName 卡会员类型名称，（员工卡，金卡...）
 */
 
 
 
   /**
 * @api {POST} operator/cardTrade 卡记录查询
 * @apiVersion 1.0.0
 * @apiName cardTrade
 * @apiGroup BaseGroup
 * @apiDescription 卡记录查询,当卡号为空时，查询当前操作员当天的所有收款记录，当卡号不为空时，查询当前卡用户在商户下当天的所有记录
 * @apiParam {String} [cardType] 卡类型
 * - 1:新卡
 * - 2:旧卡
 * @apiParam {String} [cardNo] 用户卡号,新卡为卡号，旧卡为UID
 * @apiParam {Int} page 请求的数据页面
 * @apiParam {Int} count 请求的数据量
 * @apiUse BaseRequest
 * @apiUse BaseResponse
  * @apiSuccess {Int} total 总数据量
 * @apiSuccess {Object[]} tradeList 交易记录列表
 * @apiSuccess {String} tradeList.tradeId 交易ID
 * @apiSuccess {String} tradeList.cashier 收银员编号
 * @apiSuccess {String} tradeList.cardNo 用户卡号
 * @apiSuccess {String} tradeList.realCardNo 卡面号（老卡有值，新卡为空。）
 * @apiSuccess {Int} tradeList.amount 收款金额,分
 * @apiSuccess {Int} tradeList.actualAmount 实际收款金额,分
 * @apiSuccess {Int} tradeList.accountAmount 账户扣款，分
 * @apiSuccess {Int} tradeList.subsidyAmount 补贴金额，分
 * @apiSuccess {Int} tradeList.couponAmount 优惠券折扣金额,分
 * @apiSuccess {Int} tradeList.memberAmount 会员折扣金额,分
 * @apiSuccess {Int} tradeList.accountBalanceBefore 收款前账户余额,分
 * @apiSuccess {Int} tradeList.accountBalanceAfter 收款后账户余额,分
 * @apiSuccess {String} tradeList.tradeDate 交易日期，yyyyMMdd
 * @apiSuccess {String} tradeList.tradeTime 交易时间，HHmmss
 * @apiSuccess {String} tradeList.posNo 终端POS编号
 * @apiSuccess {String} tradeList.tradeType 交易类型
 * - 1:联机消费
 * - 2:脱机消费
 * @apiSuccess {String} tradeList.refundStatus 撤销状态
 * - 0:未撤销 
 * - 1:已撤销
 */
 
 
/**
 * @api {POST} operator/refund 交易撤销
 * @apiVersion 1.0.0
 * @apiName refund
 * @apiGroup BaseGroup
 * @apiDescription 交易撤销
 * @apiParam {String} tradeId 交易ID
 * @apiUse BaseRequest
 * @apiUse BaseResponse
 */
 
 
/**
 * @api {POST} operator/orderVerify 订单验证
 * @apiVersion 1.0.0
 * @apiName orderVerify
 * @apiGroup BaseGroup
 * @apiDescription 订单验证
 * @apiParam {String} orderCode 订单核销码
 * @apiUse BaseRequest
 * @apiUse BaseResponse
 * @apiSuccess {String} orderId 订单编号
 * @apiSuccess {String} shopName 商户名称
 * @apiSuccess {Number} orderAmount 订单金额
 * @apiSuccess {Number} discountAmount 优惠金额
 * @apiSuccess {Number} paidAmount 支付金额
 * @apiSuccess {String} tradeNo 支付订单号
 * @apiSuccess {Object[]} itemInfo 商品信息集合
 * @apiSuccess {String} itemInfo.itemName 商品名称
 * @apiSuccess {Number} itemInfo.itemPrice 商品原价
 * @apiSuccess {Number} itemInfo.itemCashAmt 支付金额
 * @apiSuccess {Number} itemInfo.itemCouponAmt 优惠金额
 * @apiSuccess {Number} itemInfo.quantity 购买数量
 */
 
 
 
 /**
 * @api {POST} operator/orderConsume 订单核销
 * @apiVersion 1.0.0
 * @apiName orderConsume
 * @apiGroup BaseGroup
 * @apiDescription 订单核销
 * @apiParam {String} orderCode 订单核销码
 * @apiUse BaseRequest
 * @apiUse BaseResponse
 */
 
 
 /**
 * @api {POST} operator/settlement 结算小计
 * @apiVersion 1.0.0
 * @apiName settlement
 * @apiGroup BaseGroup
 * @apiDescription 结算小计.当前收银员从签到到当前的收款结算小计
 * @apiUse BaseRequest
 * @apiUse BaseResponse
 * @apiSuccess {Int} totalCount 收款总笔数
 * @apiSuccess {Int} totalAmount 收款总金额，分
 */
 
 
 /**
 * @api {POST} operator/heartbeat 心跳
 * @apiVersion 1.0.0
 * @apiName heartbeat
 * @apiGroup BaseGroup
 * @apiDescription 心跳，POS-APP 在心跳间隔时间内，向平台发送心跳报文
 * @apiUse BaseRequest
 * @apiUse BaseResponse
 *
 */
 
 
 /**
 * @api {POST} operator/risk 风控
 * @apiVersion 1.0.0
 * @apiName risk
 * @apiGroup BaseGroup
 * @apiDescription 风控，POS-APP 定时向系统获取风控规则参数
 * @apiUse BaseRequest
 * @apiUse BaseResponse
 * @apiSuccess {Int} payLimitAmount 小额免密支付限额
 * @apiSuccess {Int} heartbeatTime 心跳间隔时间，秒
 * @apiSuccess {Int} riskTime 风控间隔时间，秒
 * @apiSuccess {Object[]} blackList 黑名单列表
 * @apiSuccess {String} blackList.cardNo 黑名单卡号
 */
 
 
 