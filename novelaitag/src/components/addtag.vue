<template>
    <div>
        <el-dialog title="提示" :visible.sync="dialogVisible"  width="80%" :before-close="dialoghandleClose">
        <!--显示从父组件传过来的数据-->
        <div>
          <el-button type="success" style="float: right;" @click="like_find()">全局搜索</el-button> <el-input v-model="all_tag" placeholder="请输入内容" ></el-input>
      </div>
          <el-tag :key="tag" v-for="(tag,index) in  dynamicTags_china"  closable :disable-transitions="false" @close="taghandleClose(tag,index)"> {{tag}}
                    </el-tag>
                    <el-table :data="tableData.filter(data => !search || data.typename.toLowerCase().includes(search.toLowerCase())|| data.englishname.toLowerCase().includes(search.toLowerCase())|| data.chinesename.toLowerCase().includes(search.toLowerCase()))">
          <el-table-column prop="typename" label="类型" width="140"  sortable  style=" font ">
          </el-table-column>
          <el-table-column prop="englishname" label="英文"  sortable width="100">
          </el-table-column>
          <el-table-column prop="chinesename" label="中文" >
          </el-table-column>
          <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button type="danger" icon="el-icon-delete" circle  @click="delectweight(scope)"></el-button>
          <el-button type="success"  @click="addweight(scope,'{}')">{ }</el-button>
          <el-button type="success"  @click="addweight(scope,'()')">( )</el-button>
          <el-button type="success"  @click="addweight(scope,'[]')">[ ]</el-button>
          <el-button type="primary" @click="handleInputConfirm(scope.row)">添加TAG</el-button>
          <el-button  type="warning"  @click="copyid(scope.row.englishname)">复制TAG</el-button>
        </template>
        <template slot="header" slot-scope="scope">
      </template>
      </el-table-column>
        </el-table>
        <el-pagination  background layout="prev, pager, next" :total="page"  :current-page.sync="currentPage1"   @current-change="handleCurrentChange">
</el-pagination>
</el-dialog>
    </div>
</template>

<script>
  export default {
    //接收从父组件传来的tag
    props:['adddynamicTags','adddynamicTags_china'],
    data() {
      return {  
         currentPage1:53,
         all_tag:'',
          tableData: [{
                    typeid: "测试",
                    typename: "测试",
                    englishname: "测试",
                    chinesename: "测试"
                }],
        page:100,//获取多少页
        dialogVisible: false,
        ynamicTags:this.adddynamicTags,
        dynamicTags_china:this.adddynamicTags_china,
        vo:{
          name:'',
          val:this.currentPage1
        }
      };
    },
    methods: {  
      handleInputConfirm(row) {
        this.$message("添加成功")
        console.log(row)
          this.ynamicTags.push(row.englishname);
          this. dynamicTags_china.push(row.chinesename);
      },
      copyid(value) {
            console.log("复制单个", value);
            let eInput = document.createElement("input");
            eInput.value = value;
            document.body.appendChild(eInput);
            eInput.select(); //选择对象
            let copyText = document.execCommand("Copy"); //执行浏览器的复制命令
            eInput.style.display = "none";
            if (copyText)
                this.$message.success("复制成功");
        },
           //删除权重
           delectweight(weight){

          let chinesevalus=weight.row.chinesename;
          let englishvalus=weight.row.englishname;
          this.tableData[weight.$index].chinesename=chinesevalus.replace(/\{|}|\(|\)|\[|\]/g,'')
          this.tableData[weight.$index].englishname=englishvalus.replace(/\{|}|\(|\)|\[|\]/g,'')


          },
          //添加权重
          addweight(scope,weight) {
          if(weight=='{}'){
          this.tableData[scope.$index].englishname = "{" + scope.row.englishname + "}";
          this.tableData[scope.$index].chinesename = "{" + scope.row.chinesename + "}";

          }
          if(weight=='()'){
          this.tableData[scope.$index].englishname = "(" + scope.row.englishname + ")";
          this.tableData[scope.$index].chinesename = "(" + scope.row.chinesename + ")";

          }
          if(weight=='[]'){
          this.tableData[scope.$index].englishname = "[" + scope.row.englishname + "]";
          this.tableData[scope.$index].chinesename = "[" + scope.row.chinesename + "]";

          }
          },
          like_find(){
            this.vo.name=this.all_tag;
            this.$axios.post("/typelist/typelist_page_name",this.vo).then(res=>{
                console.log(res);
                this.tableData=res.data.data
                
            })
            this.vo.val=1;
            this.$axios.get('/typelist/get_count?name='+this.all_tag).then(res=>{
                  console.log("4wan")
                  console.log(res)
                  this.page=res.data.data;
                })
          },
          handleCurrentChange(val) {
        console.log(`当前页: ${val}`);
        if(val==undefined){
          this.vo.val=1
        }else{
          this.vo.val=val
        }
        //this.$router.push('/Singer?page='+this.currentPage1)
        this.$axios.post("/typelist/typelist_page_name",this.vo).then(res=>{
                console.log(res);
                this.tableData=res.data.data
                
            })
      },
              get_page(){
                this.$axios.get('/typelist/get_count?name='+this.all_tag).then(res=>{
                  console.log("4wan")
                  console.log(res)
                  this.page=res.data.data;
                })
              },
            show(){
                this.dialogVisible=true;
            },
            ceshi(){
              console.log()
          this.ynamicTags.push("camera");
          this.dynamicTags_china.push("camera");
              console.log("输出父组件数据")
              console.log(this.adddynamicTags)
            },
            taghandleClose(tag,index){
              console.log("删除标签"+tag)
              console.log("删除标签"+index)
            this.ynamicTags.splice(index, 1);
            this.dynamicTags_china.splice(index, 1);
            },

            dialoghandleClose(){
              console.log("关闭addtag窗口")
              this.dialogVisible=false
            }
    },
    created(){
      this.get_page()
      this.handleCurrentChange()
    }
  };
</script>
<style scoped>
.el-input {
  float: right;
  width: 200px;
}


</style>