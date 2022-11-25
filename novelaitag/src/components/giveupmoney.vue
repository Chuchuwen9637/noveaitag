<template>
 
<el-dialog title="谢谢大家哦" :visible.sync="dialogVisible" width="30%" >
    <h1>大家喜欢这个网站可以请UP吃辣条，学生买不起好服务器，略卡,希望大家可以体谅一下</h1>
    <h1>谢谢大家</h1>
    <img src="../assets/maomao.jpg">
 <img width="210px" height="300px" src="../assets/weixing.jpg">
 <h1>目前收到大家的喂养：不过不知道是谁，非常感谢</h1>
 <h1 v-for="item in dasahng">{{item.name}}:{{item.momey}}元</h1>
         
</el-dialog>
</template>
<script>
  export default {
    data() {
      return {
        dialogVisible: false,
        dasahng:[]
      };
    },
    methods: {
      show(){
        this.dialogVisible=true;
      },
      getdashanglist(){
        this.$axios.get("/dashang/all_dasahng").then(res=>{
          this.dasahng=res.data.data
        })
      }
    },
    created(){
        this.getdashanglist()
    }
  };
</script>