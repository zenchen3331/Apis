//定义组别
/**
* @apiDefine OneCard 一卡通SDK
*/
	
//通用报文定义
	
//接口定义	


/**
 * @api {POST} oneCard/accountInfo 获取账户信息
 * @apiVersion 1.0.0
 * @apiName accountInfo
 * @apiGroup OneCard
 * @apiDescription 获取账户信息,响应账户总资产信息，已有卡片数量。
 * @apiParam {String} userId 用户标识
 * @apiParam {String} phoneNumber 用户手机号，通过 AES 加密。 
 * @apiSuccess {Number} totalAssets 总资产，单位：分.
 * @apiSuccess {Number} crashAccount 现金账户，单位：分.
 * @apiSuccess {Number} onLineAccount 在线账户，单位：分。
 * @apiSuccess {Number} businessSubsidy 企业补贴，单位：分。
 * @apiSuccess {Number} parkSubsidy 园区补贴，单位：分。
 * @apiSuccess {Number} numberOfOwnedCard 拥有卡片数量。
 * @apiSuccess {Boolean} isHasPwd 是否设置密码
 * @apiSuccess {Double} withdrawalRate 提现费率
 * @apiSuccess {String} [realNameState] 实名认证状态
 * - 1: 已实名
 * - 0: 未实名
 */
 
 /**
 * @api {POST} oneCard/owenedCardsList 已有卡片列表
 * @apiVersion 1.0.0
 * @apiName owenedCardsList
 * @apiGroup OneCard
 * @apiDescription 获取当前用户已经拥有的卡片列表
 * @apiParam {String} userId 用户标识
 * @apiParam {String} phoneNumber 用户手机号，通过 AES 加密。 
 * @apiSuccess {Object[]} cards 卡片列表数据
 * @apiSuccess {String} [cards.number] 卡号，领卡成功后即有卡号。
 * @apiSuccess {String} cards.cardDesc 卡片说明
 * @apiSuccess {String} cards.cardRangeDesc 卡片使用范围
 * @apiSuccess {String} cards.tips 卡片温馨提示
 * @apiSuccess {Boolean} cards.isHasPwd 是否设置密码
 * @apiSuccess {Number} [cards.spentAmount] 已消费额度，单位：分。只有企业卡有这个字段值
 * @apiSuccess {Number} [cards.totalAccreditAmount] 总限额，单位：分。只有企业卡有这个字段值
 * @apiSuccess {String} cards.backgroudPic 卡面背景图片链接，把这个字段的值贴到浏览器上可以直接访问到图片。
 * @apiSuccess {String} [cards.orderId] 订单号，用于待支付的情况。
 * @apiSuccess {String} cards.typeName 卡类别名称，比如银冠卡，金冠卡，铂金卡。
 * @apiSuccess {String} cards.type 卡类别，
 * - 1：员工卡
 * - 2：企业卡
 * - 3：贵宾卡
 * @apiSuccess {String} [cards.typeId] 卡片类型ID
 * @apiSuccess {String} cards.status 卡片状态，
 * - 1：正常
 * - 2：待支付
 * - 3：待审核
 * - 4：审核失败
 * - 5：待领卡
 * - 6：退卡中
 * - 7：已挂失
 * - 8：待开卡（审核通过，正在制卡）
 * @apiSuccess {Object} [cards.secondaryCard] 副卡信息
 * @apiSuccess {String} [cards.secondaryCard.cardNumber] 副卡卡号
 * @apiSuccess {Boolean} [cards.secondaryCard.isHasPwd 是否设置密码
 * @apiSuccess {String} [cards.secondaryCard.spentAmount] 副卡已消费额度
 * @apiSuccess {String} [cards.secondaryCard.totalAccreditAmount] 副卡总额度
 * @apiSuccess {String} [cards.secondaryCard.cardStatus] 副卡状态
 * - 0: 正常启用
 * - 1: 未启用
 * @apiSuccess {String} [cards.secondaryCard.orderId] 副卡开卡订单号，如果是未支付状态，通过此订单号调起支付。
 * @apiSuccess {String} [cards.secondaryCard.orderStatus] 副卡订单状态（副卡一般来说，只有待支付，待开卡，待领卡这三种状态）
 * - 1：正常
 * - 2：待支付
 * - 3：待审核
 * - 4：审核失败
 * - 5：待领卡
 * - 6：退卡中
 * - 7：已挂失
 * - 8：待开卡（审核通过，正在制卡）
 */

 /**
 * @api {POST} oneCard/enableSecondaryCard 启用禁用副卡 
 * @apiVersion 1.0.0
 * @apiName enableSecondaryCard
 * @apiGroup OneCard
 * @apiDescription 启用禁用副卡
 * @apiParam {String} userId 用户标识
 * @apiParam {String} phoneNumber 用户手机号，通过 AES 加密。
 * @apiParam {String} cardNumber 副卡卡号
 * @apiParam {String} settingCardStatus 设置卡片状态
 * - 0: 正常启用
 * - 1: 未启用
 * @apiSuccess {String} onlyPublicReponse 只有公共响应参数，如果卡片不能启用，接口响应信息里面，说明原因，比如未设置卡片额度和密码。
 */
 
 /**
 * @api {POST} oneCard/realNameInfo 查询实名信息
 * @apiVersion 1.0.0
 * @apiName realNameInfo
 * @apiGroup OneCard
 * @apiDescription 获取当前用户已经拥有的卡片列表
 * @apiParam {String} userId 用户标识
 * @apiParam {String} phoneNumber 用户手机号，通过 AES 加密。 
 * @apiSuccess {Object} realNameInfo 实名信息，用户提交过实名信息。
 * @apiSuccess {String} realNameInfo.name 姓名
 * @apiSuccess {String} realNameInfo.certificateNumber 证件号码
 * @apiSuccess {String} company 所属公司
 * @apiSuccess {String} [realNameState] 实名认证状态
 * - 1: 已实名
 * - 0: 未实名
 * @apiSuccess {String} department 所属部门
 * @apiSuccess {String} idCardFrontPic 身份证正面，把这个字段的值贴到浏览器上可以直接访问到图片。（提交资料的时候，如果提交多次，覆盖上一次提交资料。）
 * @apiSuccess {String} idCardBackPic 身份证反面，把这个字段的值贴到浏览器上可以直接访问到图片。（提交资料的时候，如果提交多次，覆盖上一次提交资料。）
 * @apiSuccess {String} [passortSizePhoto] 一寸照片，把这个字段的值贴到浏览器上可以直接访问到图片。（提交资料的时候，如果提交多次，覆盖上一次提交资料。）
 */


/**
 * @api {POST} oneCard/setTransPwd 设置交易密码
 * @apiVersion 1.0.0
 * @apiName setTransPwd
 * @apiGroup OneCard
 * @apiDescription 设置卡片的交易密码，如果员工卡已经设置过交易密码了，那么贵宾卡类别的卡片默认使用员工卡密码。副卡
 * @apiParam {String} userId 用户标识
 * @apiParam {String} phoneNumber 用户手机号，通过 AES 加密。 
 * @apiParam {String} [cardNumber] 卡号，可选。卡详情中设置交易密码就带上卡号，账户主页重置支付密码就没有卡号。（有卡号重置卡支付密码，没有卡号重置账户密码）
 * @apiParam {String} cardPwd 卡密码，使用 SHA256 加密。
 * @apiParam {String} smsCode 验证码，如果是第一次设置交易密码，smsCode 可以不传。
 * @apiSuccess {String} onlyPublicReponse 只有公共响应参数
 */
 
 
 /**
 * @api {POST} oneCard/reportTheLoseCard 挂失卡
 * @apiVersion 1.0.0
 * @apiName reportTheLoseCard
 * @apiGroup OneCard
 * @apiDescription 卡片挂失
 * @apiParam {String} userId 用户标识
 * @apiParam {String} phoneNumber 用户手机号，通过 AES 加密。 
 * @apiParam {String} cardNumber 卡号
 * @apiParam {String} smsCode 验证码
 * @apiSuccess {String} onlyPublicReponse 只有公共响应参数
 */
 
 /**
 * @api {POST} oneCard/returnCard 退卡
 * @apiVersion 1.0.0
 * @apiName returnCard
 * @apiGroup OneCard
 * @apiDescription 退卡
 * @apiParam {String} userId 用户标识
 * @apiParam {String} phoneNumber 用户手机号，通过 AES 加密。 
 * @apiParam {String} cardNumber 卡号
 * @apiSuccess {String} onlyPublicReponse 只有公共响应参数
 */


/**
 * @api {POST} oneCard/SMSCode 获取验证码
 * @apiVersion 1.0.0
 * @apiName SMSCode
 * @apiGroup OneCard
 * @apiDescription 获取验证码，重新获取时间间隔1分钟，验证码有效期5分钟
 * @apiParam {String} userId 用户标识
 * @apiParam {String} phoneNumber 用户手机号，通过 AES 加密。 
 * @apiParam {String} businessCode 业务码
 * - 1：挂失
 * - 2：重置密码
 * - 3：申请卡片
 * @apiSuccess {String} onlyPublicReponse 只有公共响应参数
 */
 
 /**
 * @api {POST} oneCard/verifySMSCode 验证验证码
 * @apiVersion 1.0.0
 * @apiName verifySMSCode
 * @apiGroup OneCard
 * @apiDescription 验证获取验证码
 * @apiParam {String} userId 用户标识
 * @apiParam {String} phoneNumber 用户手机号，通过 AES 加密。 
 * @apiParam {String} smsCode 验证码
 * @apiParam {String} businessCode 业务码
 * - 1：挂失
 * - 2：重置密码
 * - 3：申请卡片
 * @apiSuccess {String} smsCodeToken 验证码 token，用于业务接口中。
 */
 
 /**
 * @api {POST} oneCard/cardTypeList 卡片类型列表
 * @apiVersion 1.0.0
 * @apiName cardTypeList
 * @apiGroup OneCard
 * @apiDescription 卡片类型列表
 * @apiParam {String} userId 用户标识
 * @apiParam {String} phoneNumber 用户手机号，通过 AES 加密。
 * @apiSuccess {Boolean} isEmployee 是否是员工，用于判断是否可以申请员工卡。
 * @apiSuccess {Object[]} cardTypes 卡片类型列表
 * @apiSuccess {Boolean} cardTypes.appleAble 是否可以申请这张卡片（例如，如果用户已有一张用户卡，就不能再申请用户卡了。）
 * @apiSuccess {String} cardTypes.cardDesc 卡片说明
 * @apiSuccess {String} cardTypes.backgroudPic 卡面背景图片链接，把这个字段的值贴到浏览器上可以直接访问到图片。
 * @apiSuccess {String} cardTypes.cardRangeDesc 卡片使用范围
 * @apiSuccess {String} cardTypes.tips 卡片温馨提示
 * @apiSuccess {Boolean} cardTypes.hasPassortSizePhoto 是否有一寸照片
 * @apiSuccess {String} cardTypes.name 卡片类型名称
 * @apiSuccess {String} cardTypes.type 卡片类型（只是用来展示，可以做为不同卡片类型的区分，但真正申请卡片时，需要传卡片类型ID。）
 * - 1：员工卡
 * - 2：企业卡
 * - 3：贵宾卡
 * @apiSuccess {String} cardTypes.typeId 卡片类型标识，用于申请卡片的时表面卡片类型。
 * @apiSuccess {Number} cardTypes.pledge 押金，单位：分。
 * @apiSuccess {Number} cardTypes.precharge 预充值，单位：分。
 * @apiSuccess {String} cardTypes.discountDesc 优惠描述
 */
 
 /**
 * @api {POST} oneCard/verifyRealName 实名认证
 * @apiVersion 1.0.0
 * @apiName verifyRealName
 * @apiGroup OneCard
 * @apiDescription 实名验证
 * @apiParam {String} userId 用户标识
 * @apiParam {String} realNameInfo 实名认证信息，由用户手机号+姓名+证件号码使用|拼接组成，例如 18866554433|张三|410987654318761119，然后通过 AES 加密。
 * @apiParam {String} smsCodeToken 验证码 token
 * @apiSuccess {String} onlyPublicReponse 只有公共响应参数
 */

 /**
 * @api {POST} oneCard/checkRealNameInfo 检查实名信息（用户重置支付密码）
 * @apiVersion 1.0.0
 * @apiName checkRealNameInfo
 * @apiGroup OneCard
 * @apiDescription 检查实名信息（用户重置支付密码）
 * @apiParam {String} userId 用户标识
 * @apiParam {String} realNameInfo 实名认证信息，由用户手机号+姓名+证件号码使用|拼接组成，例如 18866554433|张三|410987654318761119，然后通过 AES 加密。
 * @apiSuccess {String} onlyPublicReponse 只有公共响应参数
 */
 
/**
 * @api {POST} oneCard/applyCard 申请卡片（信息提交）
 * @apiVersion 1.0.0
 * @apiName applyCard
 * @apiGroup OneCard
 * @apiDescription 申请卡片
 * @apiParam {String} userId 用户标识
 * @apiParam {String} phoneNumber 用户手机号，通过 AES 加密。 
 * @apiParam {String} cardTypeId 卡片类型ID
 * @apiParam {String} [orderId] 订单号，如果有未支付的，审核失败的订单，此字段有值。
 * @apiParam {String} [idCardFrontPic] 身份证正面，图片Base64字符串。如果是第一张卡，必传。副卡或第二张卡片不需要传。
 * @apiParam {String} [idCardBackPic] 身份证反面，图片Base64字符串。如果是第一张卡，必传。副卡或第二张卡片不需要传。
 * @apiParam {String} [passortSizePhoto] 一寸照片，图片Base64字符串（副卡和贵宾卡为空）
 * @apiParam {String} [masterCardNumber] 主卡卡号，申请副卡时必传。
 * @apiSuccess {String} orderId 订单号
 * @apiSuccess {Boolean} isNeedPay 是否需要支付
*/

/**
 * @api {POST} oneCard/cardInfo 卡片详情查询
 * @apiVersion 1.0.0
 * @apiName cardInfo
 * @apiGroup OneCard
 * @apiDescription 卡片详情查询
 * @apiParam {String} userId 用户标识
 * @apiParam {String} phoneNumber 用户手机号，通过 AES 加密。 
 * @apiParam {String} cardNumber 卡号
 * @apiSuccess {String} [number] 卡号，领卡成功后即有卡号。
 * @apiSuccess {String} cardDesc 卡片说明
 * @apiSuccess {String} cardRangeDesc 卡片使用范围
 * @apiSuccess {String} tips 卡片温馨提示
 * @apiSuccess {Boolean} isHasPwd 是否设置密码
 * @apiSuccess {Number} [spentAmount] 已消费额度，单位：分。只有企业卡有这个字段值
 * @apiSuccess {Number} [AccreditAmount] 总限额，单位：分。只有企业卡有这个字段值
 * @apiSuccess {String} backgroudPic 卡面背景图片链接，把这个字段的值贴到浏览器上可以直接访问到图片。
 * @apiSuccess {String} [orderId] 订单号，用于待支付和审核失败的情况。
 * @apiSuccess {String} type 卡类别，
 * - 1：员工卡
 * - 2：企业卡
 * - 3：贵宾卡
 * @apiSuccess {String} [typeId] 卡片类型ID
 * @apiSuccess {String} cardStatus 卡片状态，
 * - 1：正常
 * - 2：待支付
 * - 3：待审核
 * - 4：审核失败
 * - 5：待领卡
 * - 6：退卡中
 * - 7：已挂失
 * - 8：待开卡（审核通过，正在制卡）
 * @apiSuccess {Object} [secondaryCard] 副卡信息
 * @apiSuccess {String} [secondaryCard.cardNumber] 副卡卡号
 * @apiSuccess {String} [secondaryCard.spentAmount] 副卡已消费额度
 * @apiSuccess {String} [secondaryCard.totalAccreditAmount] 副卡总额度
 * @apiSuccess {Boolean} [secondaryCard.isHasPwd] 是否设置密码
 * @apiSuccess {String} [secondaryCard.cardStatus] 副卡状态
 * - 0: 正常启用
 * - 1: 未启用
 * @apiSuccess {String} [secondaryCard.orderId] 副卡开卡订单号，如果是未支付状态，通过此订单号调起支付。
 * @apiSuccess {String} [secondaryCard.orderStatus] 副卡订单状态（副卡一般来说，只有待支付，待开卡，待领卡这三种状态）
 * - 1：正常
 * - 2：待支付
 * - 3：待审核
 * - 4：审核失败
 * - 5：待领卡
 * - 6：退卡中
 * - 7：已挂失
 * - 8：待开卡（审核通过，正在制卡）
*/

/**
 * @api {POST} oneCard/secondCardCreditsLimit 副卡额度设置
 * @apiVersion 1.0.0
 * @apiName secondCardCreditsLimit
 * @apiGroup OneCard
 * @apiDescription 副卡额度设置
 * @apiParam {String} userId 用户标识
 * @apiParam {String} phoneNumber 用户手机号，通过 AES 加密。 
 * @apiParam {String} cardNumber 卡号
 * @apiParam {String} limitAmount 限制额度，副卡限额。单位，分。
 * @apiSuccess {String} onlyPublicReponse 只有公共响应参数
*/

/**
 * @api {POST} oneCard/payOrder 订单支付
 * @apiVersion 1.0.0
 * @apiName payOrder
 * @apiGroup OneCard
 * @apiDescription 订单支付
 * @apiParam {String} userId 用户标识
 * @apiParam {String} phoneNumber 用户手机号，通过 AES 加密。 
 * @apiParam {String} orderId 订单编号
 * @apiParam {String} payChannel 支付方式
 * - 1：支付宝
 * - 2：微信
 * - 3：银联
 * @apiSuccess {String} payChannel 支付方式
 * - 1：支付宝
 * - 2：微信
 * - 3：银联
 * @apiSuccess {String} marchartName 商家名称
 * @apiSuccess {String} orderAmount 订单金额
 * @apiSuccess {String} orderId 订单号
 * @apiSuccess {String} payInfo 支付信息
*/

/**
 * @api {POST} oneCard/confirmPayOrder 订单支付结果确认
 * @apiVersion 1.0.0
 * @apiName ConfirmPayOrder
 * @apiGroup OneCard
 * @apiDescription 订单支付结果确认
 * @apiParam {String} userId 用户标识
 * @apiParam {String} phoneNumber 用户手机号，通过 AES 加密。 
 * @apiParam {String} orderId 订单编号
 * @apiSuccess {String} orderId 订单编号
 * @apiSuccess {String} payTime 支付时间，格式：yyyyMMddHHmmss。
 * @apiSuccess {String} payChannel 支付方式
 * - 1：支付宝
 * - 2：微信
 * - 3：银联
*/

/**
 * @api {POST} oneCard/applyOrder 申请订单（充值订单）
 * @apiVersion 1.0.0
 * @apiName applyOrder
 * @apiGroup OneCard
 * @apiDescription 申请订单，用于申请充值订单，或者申请贵宾卡和副卡订单。
 * @apiParam {String} userId 用户标识
 * @apiParam {String} phoneNumber 用户手机号，通过 AES 加密。 
 * @apiParam {String} [amount] 金额，申请充值订单必填。
 * @apiParam {String} orderType 订单类型
 * - 1: 充值
 * @apiSuccess {String} orderId 订单号
*/

/**
 * @api {POST} oneCard/orderInfo 订单信息查询
 * @apiVersion 1.0.0
 * @apiName orderInfo
 * @apiGroup OneCard
 * @apiDescription 订单信息查询
 * @apiParam {String} userId 用户标识
 * @apiParam {String} phoneNumber 用户手机号，通过 AES 加密。 
 * @apiParam {String} orderId 订单号
 * @apiSuccess {String} merchantName 商户名称
 * @apiSuccess {String} productName 商品名称
 * @apiSuccess {Number} totalOrderPrice 订单总价，单位：分。
 * @apiSuccess {Number} [feeOfCardMake] 制卡费，单位：分。（只有申请卡订单此字段有值）
 * @apiSuccess {Number} [feeOfCardDeposit] 卡片押金，单位：分。（只有申请卡订单此字段有值）
 * @apiSuccess {Number} feeOfOutOfPacket 实付金额，单位：分。
 * @apiSuccess {Number} feeOfDiscount 优惠金额，单位：分。
*/


/**
 * @api {POST} oneCard/applyWithdrawal 提现申请
 * @apiVersion 1.0.0
 * @apiName applyWithdrawal
 * @apiGroup OneCard
 * @apiDescription 提现申请
 * @apiParam {String} userId 用户标识
 * @apiParam {String} withdrawalInfo 提现信息，由用户手机号+姓名+支付宝账户使用|拼接组成，例如 18866554433|张三|410987654@qq.com，然后通过 AES 加密。
 * @apiParam {String} amount 提现金额，单位：分。
 * @apiParam {String} payPwd 支付密码，使用 SHA256 加密。
 * @apiSuccess {String} onlyPublicReponse 只有公共响应参数
*/


/**
 * @api {POST} oneCard/accountTransRecord 账户交易记录
 * @apiVersion 1.0.0
 * @apiName accountTransRecord
 * @apiGroup OneCard
 * @apiDescription 账户交易记录
 * @apiParam {String} userId 用户标识
 * @apiParam {String} phoneNumber 用户手机号，通过 AES 加密。 
 * @apiParam {Number} tradeType 交易类型
 * - 0: 全部
 * - 1: 充值（包含充值，退款等所有加钱的交易）
 * - 2: 消费（包含账户消费和副卡消费等所有扣钱的交易）
 * @apiParam {Number} pageIndex 页码
 * @apiParam {Number} pageSize 页面数量
 * @apiSuccess {Object[]} transRecords 交易记录集合
 * @apiSuccess {String} transRecords.id 交易记录 id
 * @apiSuccess {String} transRecords.merchant 商户名称 
 * @apiSuccess {String} transRecords.time 交易时间，yyyy-MM-dd HH:mm:ss
 * @apiSuccess {Number} transRecords.amount 交易金额，单位分。
 * @apiSuccess {Number} transRecords.type 交易类型，
 * - 1: 账户消费
 * - 2: 副卡消费
 * - 3: 账户充值
 * - 4: 账户提现
 * - 5: 交易退款
*/
