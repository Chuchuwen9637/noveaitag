<template>
  <div>
  <el-dialog width="80%" 
  title="大法师作品:上传后要刷新一下才能看到图片" :visible.sync="dialogVisible"   class="spec-dialog">
  <el-button type="primary" style="display:block;margin:0 auto" @click="innerVisible=true">上传作品</el-button>

  <el-dialog
  width="80%"
      title="上传图片"
      :visible.sync="innerVisible"
      append-to-body>
      <el-upload class="upload-demo" :on-success="uploadSuccess"  name="image" drag action="http://175.178.51.244:4431/uploadImg" multiple>
      <i class="el-icon-upload"></i>
          <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
        <div class="el-upload__tip" slot="tip">只能上传一张图片即可，且不超过3mb</div>
    </el-upload>
    <el-form :model="authortag">
      <h1>千万不要上传露点图片，图片一次上传一张</h1>
      <el-form-item label="作者">
        <el-input v-model="authortag.author"  placeholder="输入你的社交账户比如B站：春野三笠" ></el-input>
      </el-form-item>
              <el-form-item label="TAG">
                <el-input v-model="authortag.tag" placeholder="输入TAG，也就是Prompt"></el-input>
              </el-form-item>
              <el-form-item label="负面TAG" >
            <el-input v-model="authortag.negativetag"  placeholder="输入负面，也就是Negative Prompt"></el-input>
          </el-form-item>
          <el-button type="primary" style="display:block;margin:0 auto" @click="postauthortag()">上传作品</el-button>
    </el-form>
    </el-dialog>

  <el-row>
  <el-col :span="5" v-for="items in getauthortag"  :offset="1" lazy>
    <el-card :body-style="{ padding: '0px' }">
      <el-image   style="width: 100px; height: 100px;"  :preview-src-list="srcList" :src="items.url" class="image"></el-image>
      <div style="padding: 14px;">
        <span>作者：{{items.author}}</span>
        <div class="bottom clearfix">
          <el-button type="primary" icon="el-icon-copy-document" @click="copyTag(items.tag)" >TAG</el-button>
          <el-button type="text" class="button" @click="copyTag(items.negativetag)">负面TAG</el-button>
        </div>
      </div>
    </el-card>
  </el-col>
</el-row>



</el-dialog >
</div>  
</template>
<script>
  export default {
    name:"addokimge",
    data() {
      return {
        fits: ['fill', 'contain', 'cover', 'none', 'scale-down'],
        fileLimit: 1,
        innerVisible:false,
        dialogVisible: false,
        srcList: [
          'https://fuss10.elemecdn.com/8/27/f01c15bb73e1ef3793e64e6b7bbccjpeg.jpeg',
          'https://fuss10.elemecdn.com/1/8e/aeffeb4de74e2fde4bd74fc7b4486jpeg.jpeg'
        ],
        getauthortag:[{
          author:'三笠',
          url:'http://rjsum4lnm.hn-bkt.clouddn.com/890b2043-1c96-442a-82c4-4541ae46b89a',
          tag:'{{masterpiece}},best quality,1girl,solo,illustration,ahoge,young loli,gradient white hair,longhair,{{beautiful detailed eyes}}',
          negativetag:'lowres, bad anatomy, bad hands, text, error, missing fingers, extra digit, fewer digits, cropped, worst quality, low quality, normal quality, jpeg artifacts, signature, watermark, username, blurry',
        }],

        //上传的
        authortag:{
          author:'',
          url:'',
          tag:'',
          negativetag:'',
          SamplingSteps:50
        }


      };
    },
    methods: {
      copyTag(value){
        console.log("复制id", value);
            let eInput = document.createElement("input");
            eInput.value = value;
            document.body.appendChild(eInput);
            eInput.select(); //选择对象
            let copyText = document.execCommand("Copy"); //执行浏览器的复制命令
            eInput.style.display = "none";
            if (copyText)
                this.$message.success("复制TAG");
      },
      geturl(){
        this.$axios.get("/authortag/selecturl").then(res=>{
          this.srcList=res.data.data
        })
      },
      getallauthor(){
        this.$axios.get("/authortag/all_author").then(res=>{
         
          this.getauthortag=res.data.data
        })
      },
      uploadSuccess(response, file, fileList) {
        console.log("查看response")
        console.log(response)
        this.authortag.url=response.data
        },

        //上传图片 
      postauthortag(){
        if( this.authortag.url==''){
          this.$alert('请稍等图片加载完成。', '提示', {
          confirmButtonText: '确定',
        });
        }else{
          this.$axios.post("/authortag/savaauthor",this.authortag).then(res=>{
            console.log(res)
            this.$message.success("上传成功");
            this.innerVisible=false
            this.authortag.url=''
            console.log("清除url")
          })
        }
      },
     show(){
      this.dialogVisible=true
     }
    },
    created(){
      this.geturl()
      this.getallauthor()
    }
  };
</script>
<style>
.el-image__error, .el-image__inner, .el-image__placeholder{
  object-fit: contain;
}
.spec-dialog .el-dialog__body {
  padding: 3px 30px;
  overflow-y: auto;


background-size:100% 100%;
background-attachment:fixed;
}
  .time {
    font-size: 13px;
    color: #999;
  }
  
  .bottom {
    margin-top: 13px;
    line-height: 12px;
  }

  .button {
    padding: 0;
    float: right;
  }

  .image {

    display: block;
  }

  .clearfix:before,
  .clearfix:after {
      display: table;
      content: "";
  }
  .clearfix:after {
      clear: both
  }
</style>
