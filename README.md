---
title: express v1.0.0
language_tabs:
  - shell: Shell
  - http: HTTP
  - javascript: JavaScript
  - ruby: Ruby
  - python: Python
  - php: PHP
  - java: Java
  - go: Go
toc_footers: []
includes: []
search: true
code_clipboard: true
highlight_theme: darkula
headingLevel: 2
generator: "@tarslib/widdershins v4.0.5"

---

# express

> v1.0.0

# 快递e栈/登录

## POST 登录/注册

POST /phoneLogin

请求成功将手机号存入session

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|userPhone|query|string| 是 |登录手机号|
|code|query|string| 是 |用户输入的验证码|

> 返回示例

> 成功

```json
{
  "msg": "ok",
  "code": 200,
  "obj": null,
  "list": null,
  "pageInfo": null
}
```

```json
{
  "msg": "手机号码未获取短信",
  "code": 500,
  "obj": null,
  "list": null,
  "pageInfo": null
}
```

```json
{
  "msg": "注册失败，请稍后重试！",
  "code": 500,
  "obj": null,
  "list": null,
  "pageInfo": null
}
```

```json
{
  "msg": "验证码不一致,请检查",
  "code": 500,
  "obj": null,
  "list": null,
  "pageInfo": null
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## GET 退出登录

GET /logOut

清除session数据

> 返回示例

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## GET 获取手机短信验证码

GET /loginSms

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|userPhone|query|string| 是 |接受验证码的手机|

> 返回示例

> 成功

```json
{
  "msg": "验证码已发送,请查收!",
  "code": 200,
  "obj": null,
  "list": null,
  "pageInfo": null
}
```

```json
{
  "msg": "验证码下发失败,请检查手机号或稍后再试",
  "code": 500,
  "obj": null,
  "list": null,
  "pageInfo": null
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## GET 账号登录/注册

GET /login

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|loginName|query|string| 否 |none|
|password|query|string| 否 |none|

> 返回示例

> 成功

```json
{
  "msg": "服务器错误，请稍后重试！",
  "code": 500,
  "obj": null,
  "list": [],
  "pageInfo": null
}
```

```json
{
  "msg": "ok",
  "code": 200,
  "obj": {
    "uid": 7,
    "usex": 0,
    "uage": 18,
    "ucreatetime": "2022-03-04 06:01:47",
    "ulogintime": "2022-04-02 14:16:48",
    "ustate": 0,
    "utrueName": "啦啦啦",
    "uusername": "dadada",
    "uphone": "13333333333",
    "upassword": "123456",
    "uidCard": "4646546"
  },
  "list": null,
  "pageInfo": null
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

# 快递e栈/用户

## GET 获取用户信息

GET /user/userInfo

通过session获取手机号，从而查询用户信息

> 返回示例

> 成功

```json
{
  "msg": "ok",
  "code": 200,
  "obj": {
    "uid": 7,
    "usex": 0,
    "uage": 18,
    "ucreatetime": "2022-03-04 06:01:47",
    "ulogintime": "2022-04-02 14:16:48",
    "ustate": 0,
    "utrueName": "啦啦啦",
    "uusername": "dadada",
    "uphone": "13333333333",
    "upassword": "123456",
    "uidCard": "4646546"
  },
  "list": null,
  "pageInfo": null
}
```

```json
{
  "msg": "服务器错误，请稍后重试！",
  "code": 500,
  "obj": null,
  "list": null,
  "pageInfo": null
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## POST 修改用户基本信息

POST /user/update

通过session获取用户手机号，以便查询

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|user|query|string| 是 |修改信息对象|

> 返回示例

> 成功

```json
{
  "msg": "ok",
  "code": 200,
  "obj": null,
  "list": null,
  "pageInfo": null
}
```

```json
{
  "msg": "修改失败，请稍后重试！",
  "code": 500,
  "obj": null,
  "list": null,
  "pageInfo": null
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

# 快递e栈/优惠券

## GET 优惠券

GET /coupon/Num

获取剩余优惠券数量,,如果list某一节点为空，对应数量则为0

> 返回示例

> 成功

```json
{
  "msg": "ok",
  "code": 200,
  "obj": null,
  "list": [
    1,
    2,
    2,
    2
  ],
  "pageInfo": null
}
```

```json
{
  "msg": "服务器错误，请稍后重试",
  "code": 500,
  "obj": null,
  "list": null,
  "pageInfo": null
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## GET 我的优惠券数量

GET /coupon/myNum

从session中获取用户手机号，以便查询。如果list某一节点为空，对应数量则为0

> 返回示例

> 成功

```json
{
  "msg": "ok",
  "code": 200,
  "obj": null,
  "list": [
    1,
    2
  ],
  "pageInfo": null
}
```

```json
{
  "msg": "服务器错误，请稍后重试",
  "code": 500,
  "obj": null,
  "list": null,
  "pageInfo": null
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## POST 用户兑换优惠券

POST /coupon/cash

从session中获取用户手机号，以便查询。兑换扣除coupon参数对应金额和积分

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|coupon|query|string| 是 |none|

> 返回示例

> 成功

```json
{
  "msg": "ok",
  "code": 200,
  "obj": 1,
  "list": [],
  "pageInfo": null
}
```

```json
{
  "msg": "服务器错误，请稍后重试",
  "code": 500,
  "obj": null,
  "list": null,
  "pageInfo": null
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

# 快递e栈/快递

## GET 查询用户快递

GET /inventory/userList

查询用户所有快递，从session中获取用户手机号，以便查询。

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|pageNum|query|string| 否 |查询页数|

> 返回示例

> 成功

```json
{
  "msg": "ok",
  "code": 200,
  "obj": null,
  "list": null,
  "pageInfo": {
    "total": 4,
    "list": [
      {
        "recipients": "123",
        "company": "rr",
        "code": "A2-12-11",
        "inTime": "2022-02-26 06:49:19",
        "outTime": null,
        "isSent": 0,
        "estate": 0,
        "enumber": "23123",
        "ephone": "13333333333",
        "eid": 5
      },
      {
        "recipients": "121",
        "company": "aa",
        "code": "2312",
        "inTime": "2022-03-28 05:10:30",
        "outTime": null,
        "isSent": 0,
        "estate": 1,
        "enumber": "76767",
        "ephone": "13333333333",
        "eid": 8
      },
      {
        "recipients": "张三",
        "company": "顺丰快递",
        "code": "A1-01-02",
        "inTime": "2022-03-28 03:42:49",
        "outTime": null,
        "isSent": 0,
        "estate": 2,
        "enumber": "sf4687678786",
        "ephone": "13333333333",
        "eid": 9
      },
      {
        "recipients": "test",
        "company": "顺丰速运",
        "code": null,
        "inTime": null,
        "outTime": null,
        "isSent": 0,
        "estate": 0,
        "enumber": "w32132131",
        "ephone": "13333333333",
        "eid": 10
      }
    ],
    "pageNum": 1,
    "pageSize": 4,
    "size": 4,
    "startRow": 0,
    "endRow": 3,
    "pages": 1,
    "prePage": 0,
    "nextPage": 0,
    "isFirstPage": true,
    "isLastPage": true,
    "hasPreviousPage": false,
    "hasNextPage": false,
    "navigatePages": 8,
    "navigatepageNums": [
      1
    ],
    "navigateFirstPage": 1,
    "navigateLastPage": 1
  }
}
```

```json
{
  "msg": "服务器错误，请稍后重试",
  "code": 500,
  "obj": null,
  "list": null,
  "pageInfo": null
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## POST 快递取件

POST /inventory/del

调用取件码查询接口，查询成功后将快递状态设为已取件

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|code|query|string| 是 |取件码|

> 返回示例

> 成功

```json
{
  "msg": "ok",
  "code": 200,
  "obj": null,
  "list": [],
  "pageInfo": null
}
```

```json
{
  "msg": "取件失败,请稍后重试！",
  "code": 500,
  "obj": null,
  "list": [],
  "pageInfo": null
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## GET 单号查询快件

GET /inventory/query

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|number|query|string| 是 |查询单号|

> 返回示例

> 成功

```json
{
  "msg": "ok",
  "code": 200,
  "obj": {
    "recipients": "张三",
    "company": "test",
    "code": "5555",
    "inTime": "2022-02-25 06:06:55",
    "outTime": "2022-03-28 06:06:58",
    "isSent": 0,
    "estate": 1,
    "enumber": "178552",
    "ephone": "17777777777",
    "eid": 2
  },
  "list": null,
  "pageInfo": null
}
```

```json
{
  "msg": "暂无信息，请稍后重试！",
  "code": 500,
  "obj": null,
  "list": null,
  "pageInfo": null
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## POST 快递入库

POST /inventory/insert

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|inventory|query|string| 是 |快递信息对象|

> 返回示例

> 成功

```json
{
  "msg": "ok",
  "code": 200,
  "obj": null,
  "list": [],
  "pageInfo": null
}
```

```json
{
  "msg": "入库失败！",
  "code": 500,
  "obj": null,
  "list": [],
  "pageInfo": null
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## GET 取件码查询

GET /inventory/queryByCode

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|code|query|string| 是 |取件码|

> 返回示例

> 成功

```json
{
  "msg": "ok",
  "code": 200,
  "obj": {
    "recipients": "123",
    "company": "rr",
    "code": "A2-12-11",
    "inTime": "2022-02-26 06:49:19",
    "outTime": null,
    "isSent": 0,
    "estate": 0,
    "enumber": "23123",
    "ephone": "13333333333",
    "eid": 5
  },
  "list": null,
  "pageInfo": null
}
```

```json
{
  "msg": "暂无信息，请稍后重试！",
  "code": 500,
  "obj": null,
  "list": null,
  "pageInfo": null
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## PUT 更新快件信息

PUT /inventory/{id}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|path|string| 是 |更新快件id|

> 返回示例

> 成功

```json
{
  "msg": "ok",
  "code": 200,
  "obj": null,
  "list": [],
  "pageInfo": null
}
```

```json
{
  "msg": "修改失败！",
  "code": 500,
  "obj": null,
  "list": [],
  "pageInfo": null
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## GET 用户排行榜信息

GET /inventory/top

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|tableNumber|query|string| 否 |1：总排行榜 2：年排行榜 3：月排行榜|

> 返回示例

> 成功

```json
{
  "msg": "ok",
  "code": 200,
  "obj": null,
  "list": [
    {
      "e_phone": "13333333333",
      "count": 5,
      "userName": "dadada"
    },
    {
      "e_phone": "16675982450",
      "count": 1,
      "userName": null
    },
    {
      "e_phone": "16666666666",
      "count": 1,
      "userName": "user"
    },
    {
      "e_phone": "12222222222",
      "count": 1,
      "userName": "aa"
    },
    {
      "e_phone": "16675664777",
      "count": 1,
      "userName": "uu"
    }
  ],
  "pageInfo": null
}
```

```json
{
  "msg": "服务器错误，请稍后重试！",
  "code": 500,
  "obj": null,
  "list": [],
  "pageInfo": null
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

# 快递e栈/钱包

## GET 用户钱包信息

GET /balance/info

通过session获取手机号，从而查询用户信息

> 返回示例

> 成功

```json
{
  "msg": "ok",
  "code": 200,
  "obj": {
    "balance": 990,
    "integral": 5498,
    "bstate": 0,
    "bphone": "13333333333",
    "bid": 1
  },
  "list": null,
  "pageInfo": null
}
```

```json
{
  "msg": "服务器错误，请稍后重试！",
  "code": 500,
  "obj": null,
  "list": [],
  "pageInfo": null
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## GET 使用兑换码

GET /balance/pay

兑换码充值

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|Num|query|string| 否 |none|

> 返回示例

> 成功

```json
{
  "msg": "ok",
  "code": 200,
  "obj": null,
  "list": [],
  "pageInfo": null
}
```

```json
{
  "msg": "兑换码无效，请校验后重试！",
  "code": 500,
  "obj": null,
  "list": [],
  "pageInfo": null
}
```

```json
{
  "msg": "充值失败，请稍后重试！",
  "code": 500,
  "obj": null,
  "list": [],
  "pageInfo": null
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

# 快递e栈/消息

## GET 获取所有用户通知

GET /message/inform

> 返回示例

> 成功

```json
{
  "msg": "ok",
  "code": 200,
  "obj": null,
  "list": [
    {
      "id": 1,
      "message": "你有快递未领取，请尽快领取！",
      "phone": "13333333333",
      "createTime": "2022-03-27 03:57:18",
      "state": 0,
      "type": 0
    },
    {
      "id": 3,
      "message": "你有快递超时未取已退回，有疑问请联系快递公司",
      "phone": "13333333333",
      "createTime": "2022-03-27 05:22:22",
      "state": 0,
      "type": 0
    },
    {
      "id": 4,
      "message": "你有快递到达站点，取件码：A2-02-11,请尽快领取！",
      "phone": "13333333333",
      "createTime": "2022-03-27 06:05:15",
      "state": 0,
      "type": 0
    }
  ],
  "pageInfo": null
}
```

```json
{
  "msg": "服务器错误，请稍后重试！",
  "code": 500,
  "obj": null,
  "list": null,
  "pageInfo": null
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## GET 获取所有公告

GET /message/notice

通过session获取手机号，从而查询用户信息

> 返回示例

> 成功

```json
{
  "msg": "ok",
  "code": 200,
  "obj": null,
  "list": [
    {
      "id": 2,
      "message": "由于疫情原因，快递服务暂停，开放时间另行通知，若造成不便敬请谅解！",
      "phone": null,
      "createTime": "2022-03-27 05:03:37",
      "state": 0,
      "type": 1
    },
    {
      "id": 9,
      "message": "tttt",
      "phone": null,
      "createTime": "2022-03-31 15:25:59",
      "state": 0,
      "type": 1
    }
  ],
  "pageInfo": null
}
```

```json
{
  "msg": "服务器错误，请稍后重试！",
  "code": 500,
  "obj": null,
  "list": null,
  "pageInfo": null
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## GET 获取用户所有消息

GET /message/getAll

通过session获取手机号，从而查询用户信息

> 返回示例

> 成功

```json
{
  "msg": "ok",
  "code": 200,
  "obj": null,
  "list": [
    {
      "id": 1,
      "message": "你有快递未领取，请尽快领取！",
      "phone": "13333333333",
      "createTime": "2022-03-27 03:57:18",
      "state": 0,
      "type": 0
    },
    {
      "id": 2,
      "message": "由于疫情原因，快递服务暂停，开放时间另行通知，若造成不便敬请谅解！",
      "phone": null,
      "createTime": "2022-03-27 05:03:37",
      "state": 0,
      "type": 1
    },
    {
      "id": 3,
      "message": "你有快递超时未取已退回，有疑问请联系快递公司",
      "phone": "13333333333",
      "createTime": "2022-03-27 05:22:22",
      "state": 0,
      "type": 0
    },
    {
      "id": 4,
      "message": "你有快递到达站点，取件码：A2-02-11,请尽快领取！",
      "phone": "13333333333",
      "createTime": "2022-03-27 06:05:15",
      "state": 0,
      "type": 0
    },
    {
      "id": 9,
      "message": "tttt",
      "phone": null,
      "createTime": "2022-03-31 15:25:59",
      "state": 0,
      "type": 1
    }
  ],
  "pageInfo": null
}
```

```json
{
  "msg": "服务器错误，请稍后重试！",
  "code": 500,
  "obj": null,
  "list": null,
  "pageInfo": null
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

# 快递e栈/二维码

## GET 生成二维码

GET /qrcode

> 返回示例

> 成功

```json
{
  "msg": "express_A2-12-11",
  "code": 200,
  "obj": null,
  "list": null,
  "pageInfo": null
}
```

```json
{
  "msg": "取件码获取出错,请用户重新操作",
  "code": 500,
  "obj": null,
  "list": null,
  "pageInfo": null
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## GET 储存快递二维码生成信息

GET /createQRCode

从session中获取用户手机号，将二维码信息存入session

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|code|query|string| 否 |取件码|
|type|query|string| 否 |信息类型|

> 返回示例

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## GET 查询扫描结果对象

GET /findExpressByCode

> 返回示例

> 成功

```json
{
  "msg": "ok",
  "code": 200,
  "obj": {
    "enumber": "sf7465465464",
    "company": "顺丰速运",
    "ephone": "13333333333",
    "e_state": "2022-03-04 06:01:47",
    "code": "2022-03-04 06:01:47",
    "inTime": "2022-03-04 06:01:47"
  },
  "list": null,
  "pageInfo": null
}
```

```json
{
  "msg": "取件码不存在",
  "code": 500,
  "obj": null,
  "list": null,
  "pageInfo": null
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## GET 扫码后更新信息

GET /updateStatus

> 返回示例

> 成功

```json
{
  "msg": "ok",
  "code": 200,
  "obj": null,
  "list": null,
  "pageInfo": null
}
```

```json
{
  "msg": "取件码不存在,请用户更新二维码",
  "code": 500,
  "obj": null,
  "list": null,
  "pageInfo": null
}
```

```json
{
  "msg": "取件失败,请用户更新二维码",
  "code": 500,
  "obj": null,
  "list": null,
  "pageInfo": null
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

# 快递e栈/运单

## GET 添加运单

GET /transport/insert

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|transport|query|string| 是 |none|

> 返回示例

> 成功

```json
{
  "msg": "ok",
  "code": 200,
  "obj": null,
  "list": null,
  "pageInfo": null
}
```

```json
{
  "msg": "服务器错误，请稍后重试！",
  "code": 500,
  "obj": null,
  "list": null,
  "pageInfo": null
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

# 快递e栈/微信

## GET 获取微信配置信息

GET /WechatConfig

> 返回示例

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

# 快递e栈后台/首页数据

## GET 当天数据

GET /console/numTime

> 返回示例

> 成功

```json
{
  "msg": "ok",
  "code": 200,
  "obj": null,
  "list": [
    0,
    0,
    0,
    0
  ],
  "pageInfo": null
}
```

```json
{
  "msg": "服务器错误，请稍后重试！",
  "code": 500,
  "obj": null,
  "list": null,
  "pageInfo": null
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## GET 总体数据

GET /console/num

> 返回示例

> 成功

```json
{
  "msg": "ok",
  "code": 200,
  "obj": null,
  "list": [
    11,
    7,
    1,
    19
  ],
  "pageInfo": null
}
```

```json
{
  "msg": "服务器错误，请稍后重试！",
  "code": 500,
  "obj": null,
  "list": null,
  "pageInfo": null
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

# 快递e栈后台/快递

## POST 快递入库

POST /transport/add

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|inventory|query|string| 否 |入库快递信息对象|

> 返回示例

> 成功

```json
{
  "msg": "添加成功！",
  "code": 200,
  "obj": null,
  "list": [],
  "pageInfo": null
}
```

```json
{
  "msg": "添加失败，请稍后重试！",
  "code": 500,
  "obj": null,
  "list": null,
  "pageInfo": null
}
```

```json
{
  "msg": "数据有误，请稍后重试！",
  "code": 500,
  "obj": null,
  "list": null,
  "pageInfo": null
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## POST 发送短信通知

POST /transport/sentSMS

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|inventory|query|string| 否 |none|

> 返回示例

> 成功

```json
{
  "msg": "ok",
  "code": 200,
  "obj": null,
  "list": null,
  "pageInfo": null
}
```

```json
{
  "msg": "发送失败，请检查用户信息！",
  "code": 500,
  "obj": null,
  "list": null,
  "pageInfo": null
}
```

```json
{
  "msg": "发送失败，请稍后重试！",
  "code": 500,
  "obj": null,
  "list": null,
  "pageInfo": null
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## POST 修改快递信息

POST /transport/update

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|inventory|query|string| 否 |none|

> 返回示例

> 成功

```json
{
  "msg": "ok",
  "code": 200,
  "obj": null,
  "list": null,
  "pageInfo": null
}
```

```json
{
  "msg": "修改失败，请稍后重试！",
  "code": 500,
  "obj": null,
  "list": null,
  "pageInfo": null
}
```

```json
{
  "msg": "数据有误，修改失败！",
  "code": 500,
  "obj": null,
  "list": null,
  "pageInfo": null
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

# 快递e栈后台/登录

## GET 退出登录

GET //logOut

清除session数据

> 返回示例

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## POST 登录

POST /login

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|username|query|string| 是 |none|
|password|query|string| 是 |none|
|code|query|string| 否 |none|

> 返回示例

> 成功

```json
{
  "msg": "ok",
  "code": 200,
  "obj": {
    "id": 7,
    "username": "admin",
    "uage": 18,
    "password": "6db3aabc3ca5f673ac4e2b8221c539d3",
    "state": "0",
    "type": 0
  },
  "list": null,
  "pageInfo": null
}
```

```json
{
  "msg": "验证码不正确！",
  "code": 500,
  "obj": null,
  "list": null,
  "pageInfo": null
}
```

```json
{
  "msg": "用户不存在！",
  "code": 500,
  "obj": null,
  "list": null,
  "pageInfo": null
}
```

```json
{
  "msg": "账号或密码不正确！",
  "code": 500,
  "obj": null,
  "list": null,
  "pageInfo": null
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## GET 验证码

GET /getVerifyCode

通过io流输出验证码图片

> 返回示例

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

# 快递e栈后台/消息

## POST 发送公告

POST /message/addNotice

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|note|query|string| 否 |公告信息|

> 返回示例

> 成功

```json
{
  "msg": "ok",
  "code": 200,
  "obj": null,
  "list": null,
  "pageInfo": null
}
```

```json
{
  "msg": "发送失败！",
  "code": 500,
  "obj": null,
  "list": null,
  "pageInfo": null
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## POST 对用户发送通知

POST /message/add

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|note|query|string| 否 |发送的消息|
|phone|query|string| 否 |发送的用户手机号|

> 返回示例

> 成功

```json
{
  "msg": "ok",
  "code": 200,
  "obj": null,
  "list": null,
  "pageInfo": null
}
```

```json
{
  "msg": "发送失败！",
  "code": 500,
  "obj": null,
  "list": null,
  "pageInfo": null
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

# 快递e栈后台/用户

## GET 用户列表

GET /user/list

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|pageNum|query|string| 否 |页数|
|pageSize|query|string| 否 |页大小|
|name|query|string| 否 |模糊查询|

> 返回示例

> 成功

```json
{
  "msg": "ok",
  "code": 200,
  "obj": null,
  "list": null,
  "pageInfo": {
    "total": 10,
    "list": [
      {
        "packageNum": 1,
        "returnNum": 0,
        "sendNum": 0,
        "uid": 1,
        "uage": 18,
        "usex": 0,
        "ustate": 0,
        "uphone": "16675664777",
        "upassword": "5465456ee",
        "ucreatetime": "2022-02-14 05:15:06",
        "utrueName": "张三",
        "uusername": "帅哥",
        "uidCard": "441900200207012614",
        "ulogintime": "2022-03-02 21:03:52"
      },
      {
        "packageNum": 1,
        "returnNum": 0,
        "sendNum": 0,
        "uid": 2,
        "uage": 18,
        "usex": 0,
        "ustate": 0,
        "uphone": "16666666666",
        "upassword": "123456",
        "ucreatetime": "2022-02-14 05:15:37",
        "utrueName": "李四",
        "uusername": "user",
        "uidCard": "111111111",
        "ulogintime": "2022-02-14 05:15:41"
      },
      {
        "packageNum": 0,
        "returnNum": 0,
        "sendNum": 0,
        "uid": 3,
        "uage": 18,
        "usex": 0,
        "ustate": 0,
        "uphone": "17777777777",
        "upassword": "123456",
        "ucreatetime": "2022-03-01 05:43:43",
        "utrueName": "test",
        "uusername": "tt",
        "uidCard": "46767676",
        "ulogintime": "2022-03-01 05:43:47"
      },
      {
        "packageNum": 1,
        "returnNum": 0,
        "sendNum": 0,
        "uid": 4,
        "uage": 18,
        "usex": 0,
        "ustate": 0,
        "uphone": "12222222222",
        "upassword": "123456",
        "ucreatetime": "2022-03-01 05:44:08",
        "utrueName": "ee",
        "uusername": "aa",
        "uidCard": "23213123",
        "ulogintime": "2022-03-01 05:44:11"
      },
      {
        "packageNum": 1,
        "returnNum": 0,
        "sendNum": 0,
        "uid": 5,
        "uage": 18,
        "usex": 0,
        "ustate": 0,
        "uphone": "14444444444",
        "upassword": "213123",
        "ucreatetime": "2022-03-01 05:44:42",
        "utrueName": "tt",
        "uusername": "tt",
        "uidCard": "2312312",
        "ulogintime": "2022-03-01 05:44:45"
      }
    ],
    "pageNum": 1,
    "pageSize": 5,
    "size": 5,
    "startRow": 1,
    "endRow": 5,
    "pages": 2,
    "prePage": 0,
    "nextPage": 2,
    "isFirstPage": true,
    "isLastPage": false,
    "hasPreviousPage": false,
    "hasNextPage": true,
    "navigatePages": 8,
    "navigatepageNums": [
      1,
      2
    ],
    "navigateFirstPage": 1,
    "navigateLastPage": 2
  }
}
```

```json
{
  "msg": "服务器错误，请稍后重试！",
  "code": 500,
  "obj": null,
  "list": null,
  "pageInfo": null
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

# 快递e栈后台/运单

## GET 运单列表

GET /transport/list

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|pageNum|query|string| 否 |页数|
|pageSize|query|string| 否 |页大小|
|number|query|string| 否 |单号模糊查询|

> 返回示例

> 成功

```json
{
  "msg": "ok",
  "code": 200,
  "obj": null,
  "list": null,
  "pageInfo": {
    "total": 11,
    "list": [
      {
        "recipients": "张三88",
        "company": "test88",
        "code": "B2-09-12",
        "inTime": "2022-02-26 05:40:27",
        "outTime": "2022-03-28 03:45:02",
        "isSent": 0,
        "estate": 1,
        "ephone": "13333333333",
        "eid": 1,
        "enumber": "121345688"
      },
      {
        "recipients": "张三",
        "company": "test",
        "code": "5555",
        "inTime": "2022-02-25 06:06:55",
        "outTime": "2022-03-28 06:06:58",
        "isSent": 0,
        "estate": 1,
        "ephone": "17777777777",
        "eid": 2,
        "enumber": "178552"
      },
      {
        "recipients": "张三",
        "company": "test",
        "code": "5557",
        "inTime": "2022-02-26 06:48:40",
        "outTime": null,
        "isSent": 0,
        "estate": 0,
        "ephone": "12222222222",
        "eid": 3,
        "enumber": "657657465"
      },
      {
        "recipients": "ss",
        "company": "test",
        "code": "7777",
        "inTime": "2022-02-26 06:49:02",
        "outTime": null,
        "isSent": 0,
        "estate": 0,
        "ephone": "14444444444",
        "eid": 4,
        "enumber": "78797"
      },
      {
        "recipients": "123",
        "company": "rr",
        "code": "A2-12-11",
        "inTime": "2022-02-26 06:49:19",
        "outTime": null,
        "isSent": 0,
        "estate": 0,
        "ephone": "13333333333",
        "eid": 5,
        "enumber": "23123"
      }
    ],
    "pageNum": 1,
    "pageSize": 5,
    "size": 5,
    "startRow": 1,
    "endRow": 5,
    "pages": 3,
    "prePage": 0,
    "nextPage": 2,
    "isFirstPage": true,
    "isLastPage": false,
    "hasPreviousPage": false,
    "hasNextPage": true,
    "navigatePages": 8,
    "navigatepageNums": [
      1,
      2,
      3
    ],
    "navigateFirstPage": 1,
    "navigateLastPage": 3
  }
}
```

```json
{
  "msg": "服务器错误，请稍后重试！",
  "code": 500,
  "obj": null,
  "list": null,
  "pageInfo": null
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## GET 编号查询运单

GET /transport/{id}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|path|string| 是 |运单编号|

> 返回示例

> 成功

```json
{
  "msg": "ok",
  "code": 200,
  "obj": {
    "recipients": "张三88",
    "company": "test88",
    "code": "B2-09-12",
    "inTime": "2022-02-26 05:40:27",
    "outTime": "2022-03-28 03:45:02",
    "isSent": 0,
    "estate": 1,
    "ephone": "13333333333",
    "eid": 1,
    "enumber": "121345688"
  },
  "list": null,
  "pageInfo": null
}
```

```json
{
  "msg": "获取失败，请稍后重试！",
  "code": 500,
  "obj": null,
  "list": null,
  "pageInfo": null
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## POST 删除运单

POST /transport//del/{id}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|path|string| 是 |运单编号|

> 返回示例

> 成功

```json
{
  "msg": "删除成功！",
  "code": 200,
  "obj": null,
  "list": null,
  "pageInfo": null
}
```

```json
{
  "msg": "删除失败！",
  "code": 200,
  "obj": null,
  "list": null,
  "pageInfo": null
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

# 数据模型

