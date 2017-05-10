//index.js
//获取应用实例
var app = getApp()
var addressValue = ''
var phoneNumValue = ''
var openid = ''
var user = ''
var oldPhoneNum = ''
var account = {
  "accountid": "",
  "name": "",
  "phone": ""
};
Page({
  data: {
    motto: 'Hello World',
    userInfo: {},
    addressValue: '',
    phoneNum: ""
  },
  //事件处理函数
  bindViewTap: function () {
    wx.showModal({
      title: '提示',
      content: '这是一个模态弹窗',
      success: function (res) {
        if (res.confirm) {
          console.log('用户点击确定')
        } else if (res.cancel) {
          console.log('用户点击取消')
        }
      }
    })
  },
  addressEvent: function (e) {
    addressValue = e.detail.value;
  },
  phoneNumEvent: function (e) {
    phoneNumValue = e.detail.value;
  },
  buttonEvent: function (e) {
    var that = this
    if (/^\s*$/.test(addressValue)) {
      wx.showToast({
        title: '上车地点不能为空',
        icon: 'success',
        duration: 2000
      })
      reurn;
    }
    if (/^\s*$/.test(phoneNumValue)) {
      phoneNumValue = oldPhoneNum;
      if (/^\s*$/.test(phoneNumValue)) {
          wx.showToast({
            title: '电话号码不能为空',
            icon: 'success',
            duration: 2000
          })
        reurn;
      }
      
    }
    if (phoneNumValue.length > 11) {
      wx.showToast({
        title: '电话号码长度不能超过11位',
        icon: 'success',
        duration: 2000
      })
      reurn;
    }
    if (!/^\d*$/.test(phoneNumValue)) {
      wx.showToast({
        title: '电话号码格式错误',
        icon: 'success',
        duration: 2000
      })
      reurn;
    }
    if (oldPhoneNum != "" && phoneNumValue != oldPhoneNum) {
      wx.showModal({
        content: "确定要更换手机号码为:  "+ phoneNumValue,
        success: function (res) {
          if (res.confirm) {
            that.addOnboardInfo();
          } else if (res.cancel) {
            console.log('用户点击取消')
          }
        }
      })
    }else{
      that.addOnboardInfo();
    }


  },
  onLoad: function () {
    console.log('onLoad')
    var that = this
    //调用应用实例的方法获取全局数据
    app.getUserInfo(function (userInfo) {
      user = userInfo;
      //更新数据
      that.setData({
        userInfo: userInfo
      })
    })
    wx.login({
      success: function (res) {
        if (res.code) {
          wx.request({
            url: 'https://api.weixin.qq.com/sns/jscode2session?appid=' + 'wx9735fefbb45f7033' + '&secret=' + '964ac6cc7bc88b1a9ae6d451960d1db9' + '&js_code=' + res.code + '&grant_type=authorization_code',
            data: {
              code: res.code
            },
            success: function (res) {
              openid = res.data.openid;
              console.log(res.data)

              wx.request({
                url: 'https://newone.xyz/lianyun/hq/getAccountInfo_userMg.do',
                data: {
                  'accountId': openid
                },
                header: {
                  'content-type': 'application/json'
                },
                success: function (data) {
                  if (data.data.success) {
                    account.phone = data.data.account.phone;
                    oldPhoneNum = data.data.account.phone;
                    that.setData({
                      phoneNum: account.phone
                    })
                  }

                  console.log(data.data.message)
                }
              })
            }
          })
        }
      }
    })
  },
  addOnboardInfo(){
    wx.showModal({
      content: "您的上车地点是：" + addressValue,
      success: function (res) {
        if (res.confirm) {
          var onboardInfo = {
            "accountid": openid,
            "accountname": "n1",
            "onboardaddress": "d1"
          };

          onboardInfo.accountname = user.nickName;
          onboardInfo.onboardaddress = addressValue;

          account = {
            "accountid": openid,
            "name": user.nickName,
            "phone": phoneNumValue
          };
          wx.request({
            url: 'https://newone.xyz/lianyun/hq/addOnboardInfo_onboard.do',
            data: {
              'onboardInfo': JSON.stringify(onboardInfo),
              'account': JSON.stringify(account)
            },
            header: {
              'content-type': 'application/json'
            },
            success: function (data) {
              if (data.data.success) {
                wx.showToast({
                  title: data.data.message,
                  icon: 'success',
                  duration: 2000
                })
              }
              console.log(data.data.message)
            }
          })
        } else if (res.cancel) {
          console.log('用户点击取消')
        }
      }
    })
  }
})
wx.getUserInfo({
  success: function (res) {
    var userInfo = res.userInfo
    var nickName = userInfo.nickName
    var avatarUrl = userInfo.avatarUrl
    var gender = userInfo.gender //性别 0：未知、1：男、2：女
    var province = userInfo.province
    var city = userInfo.city
    var country = userInfo.country
  }
})
/*
var socketOpen = false
var socketMsgQueue = []
wx.connectSocket({
  url: 'wss://newone.xyz/lianyun/forwardWebSocket'
})

wx.onSocketOpen(function(res) {
  socketOpen = true
  socketMsgQueue = []
})

function sendSocketMessage(msg) {
  if (socketOpen) {
    wx.sendSocketMessage({
      data:msg
    })
  } else {
     socketMsgQueue.push(msg)
  }
}
wx.onSocketMessage(function(res) {
   wx.showToast({
            title: "您的上车地点是："+ res.data + ' 请等待...',
            icon: 'success',
            duration: 2000
          })
  console.log('收到服务器内容：' + res.data)
})
*/