//index.js
//获取应用实例
var app = getApp()
var inputValue = ''
var user = ''
Page({
  data: {
    motto: 'Hello World',
    userInfo: {},
    inputValue: ''
  },
  //事件处理函数
  bindViewTap: function() {
    wx.showModal({
      title: '提示',
      content: '这是一个模态弹窗',
      success: function(res) {
        if (res.confirm) {
          console.log('用户点击确定')
        } else if (res.cancel) {
          console.log('用户点击取消')
        }
      }
    })
  },
  bindKeyInput: function(e) {
      inputValue =  e.detail.value;
  },
  buttonEvent:  function(e)  {
    wx.showModal({
      content: "您的上车地点是："+ inputValue,
      success: function(res) {
        if (res.confirm) {
          var onboardInfo = {
            "accountid" : "u0001",
            "accountname" : "n1",
            "onboardaddress" : "d1"
          };
          onboardInfo.accountname = user.nickName;
	        onboardInfo.onboardaddress = inputValue;
          wx.request({
          url: 'https://newone.xyz/lianyun/hq/addOnboardInfo_onboard.do', 
          data: {
           'onboardInfo':JSON.stringify(onboardInfo)
          },
          header: {
              'content-type': 'application/json'
          },
          success: function(data) {
            if (data.data.success){
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
  },
  onLoad: function () {
    console.log('onLoad')
    var that = this
    //调用应用实例的方法获取全局数据
    app.getUserInfo(function(userInfo){
      user = userInfo;
      //更新数据
      that.setData({
        userInfo:userInfo
      })
    })
  }
})

wx.getUserInfo({
  success: function(res) {
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