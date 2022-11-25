<template>
<el-container style=" border: 1px solid #eee">
    <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
        <el-menu default-active="1-4-1" class="el-menu-vertical-demo"  @select="handleSelect">
  <el-submenu index="1">
    <template slot="title">
      <i class="el-icon-user-solid"></i>
      <span slot="title">人物样貌</span>
    </template>
    <el-menu-item-group>
      <el-menu-item index="人体">人体</el-menu-item>
      <el-menu-item index="姿势">姿势</el-menu-item>
      <el-menu-item index="发型">发型</el-menu-item>
      <el-menu-item index="表情">表情</el-menu-item>
      <el-menu-item index="眼睛">眼睛</el-menu-item>
    </el-menu-item-group>
  </el-submenu>
  <el-submenu index="2">
    <template slot="title">
      <i class="el-icon-goods"></i>
      <span slot="title">服装类型</span>
    </template>
    <el-menu-item-group>
      <el-menu-item index="衣服">衣服</el-menu-item>
      <el-menu-item index="饰品">饰品</el-menu-item>
      <el-menu-item index="袜子">袜子</el-menu-item>
    </el-menu-item-group>
  </el-submenu>
  <el-submenu index="3">
    <template slot="title">
      <i class="el-icon-user"></i>
      <span slot="title">人物画风</span>
    </template>
    <el-menu-item-group>
      
      <el-menu-item index="风格">风格(画质)</el-menu-item>
      <el-menu-item index="环境">环境</el-menu-item>
    </el-menu-item-group>
  </el-submenu>
  <el-submenu index="4">
    <template slot="title">
      <i class="el-icon-picture-outline-round"></i>
      <span slot="title">环境样式</span>
    </template>
    <el-menu-item-group>
      <el-menu-item index="背景">背景</el-menu-item>
      <el-menu-item index="物品">物品</el-menu-item>
    </el-menu-item-group>
  </el-submenu>

  <el-submenu index="5">
    <template slot="title">
      <i class="el-icon-notebook-1"></i>
      <span slot="title">元素法典</span>
    </template>
    <el-menu-item-group>
      <el-menu-item @click="setbooks('https://docs.qq.com/doc/DWHl3am5Zb05QbGVs')">第一卷</el-menu-item>
      <el-menu-item @click="setbooks('https://docs.qq.com/doc/DWGh4QnZBVlJYRkly')">第一点五卷</el-menu-item>
      <el-menu-item @click="setbooks('https://docs.qq.com/doc/DWEpNdERNbnBRZWNL')">第二卷</el-menu-item>
    </el-menu-item-group>
  </el-submenu>
  <el-menu-item-group>
          <el-menu-item @click="router_i()">大魔法师</el-menu-item>
          <el-menu-item @click="setbooks('https://www.iaidraw.com/')">AI 绘画</el-menu-item>
          <el-menu-item @click="showaddtag()">4万TAG集合</el-menu-item>
          <el-menu-item  @click="gievmoney()">谢谢你们喜欢</el-menu-item>
        </el-menu-item-group>
</el-menu>
    </el-aside>
    
    <el-container>
      <el-header style=" font-size: 20px">
        <el-dropdown>
          <i class="el-icon-setting" style="margin-right: 15px"></i>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item>查看</el-dropdown-item>
            <el-dropdown-item>新增</el-dropdown-item>
            <el-dropdown-item>删除</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
        <span>Bilibili:春野三笠，持续更新 ：Q群交流：865601667</span>
      </el-header>
      
      <el-main >
        <addokimge ref="addokimge"></addokimge>
        <gm ref="gm"></gm>
        <addtag ref="addtag" :adddynamicTags="dynamicTags" :adddynamicTags_china="dynamicTags_china"></addtag>
        <div  style="border: 1px solid red;">
          <!--标签-->
          <el-tag :key="tag" v-for="(tag,index) in dynamicTags_china"  closable :disable-transitions="false" @close="handleClose(tag,index)"> {{tag}}
                    </el-tag>
        <el-button  type="success" style="display:block;margin:0 auto" @click="copyid666()">复制全部</el-button>
        </div>
        <el-table :data="tableData.filter(data => !search || data.typename.toLowerCase().includes(search.toLowerCase())|| data.englishname.toLowerCase().includes(search.toLowerCase())|| data.chinesename.toLowerCase().includes(search.toLowerCase()))">
          <el-table-column prop="typename" label="类型" width="140"  sortable  style=" font ">
          </el-table-column>
          <el-table-column prop="englishname" label="英文"  sortable width="100">
          </el-table-column>
          <el-table-column prop="chinesename" label="中文" >
          </el-table-column>
          <el-table-column prop="" label="贡献者" width="80" fixed="left">
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
        <el-input
          v-model="search"
          size="mini"
          placeholder="输入关键字搜索"/>
      </template>
      </el-table-column>
        </el-table>
      </el-main>
    </el-container>
  </el-container>
</template>
  <script>
import addokimge from './okimge.vue'
import  gm from '@/components/giveupmoney'
import addtag from '@/components/addtag'
    export default {
      components:{
        addokimge,
        gm,
        addtag
  },
    data() {
        return {
          dynamicTags: [],
          dynamicTags_china: [],
            tableData: [{
                    typeid: "测试",
                    typename: "测试",
                    englishname: "测试",
                    chinesename: "测试"
                }],
              copytableData: [
                ],
            search: "",
            textarea: "",
            typeListdto:{
            typename:''
            }
        };
    },
      methods: {
        setbooks(url){
          var tempwindow=window.open('_blank');
             tempwindow.location=url;
        },

        showaddtag(){
          this.$refs.addtag.show()
        }
        ,
        gievmoney(){
          this.$refs.gm.show()
        },
        //删除标签
        handleClose(tag,index) {
          console.log("删除标签"+tag)
          console.log("删除标签"+index)
        this.dynamicTags.splice(index, 1);
        this.dynamicTags_china.splice(index, 1);
      },
      //添加标签
      handleInputConfirm(row) {
        this.$message("添加成功")
        console.log(row)
          this.dynamicTags.push(row.englishname);
          this.dynamicTags_china.push(row.chinesename);
      },
      //查询数据
        handleSelect(key, keyPath) {
          if(key==this.typeListdto.typename){
            console.log("没反应")
            return
          }else{
            console.log("传数据")
            this.typeListdto.typename=key;
            this.$axios.post("/typelist/find_byname",this.typeListdto).then(res => {
                this.tableData= res.data.data;
                this.copytableData=this.tableData;
            });
          }
      },
      //弹出大魔法师窗口
        router_i() {
            this.$refs.addokimge.show();
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
        copyid666() {
            let value = this.dynamicTags;
            console.log("复制全部", value);
            let eInput = document.createElement("input");
            eInput.value = value;
            document.body.appendChild(eInput);
            eInput.select(); //选择对象
            let copyText = document.execCommand("Copy"); //执行浏览器的复制命令
            eInput.style.display = "none";
            if (copyText)
                this.$message.success("复制成功");
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
    },
    created() {
          this.handleSelect("人体",null)
    },
}

  </script>
    <style>
    .el-header {
      background-color: #B3C0D1;
      color: #333;
      line-height: 60px;
    }

    .el-aside {
      color: #333;
    }
    .el-table {
  color: #333; 
  font-weight:bold;
    }
    .el-table .warning-row {
    background: oldlace;
  }

  .el-table .success-row {
    background: #f0f9eb;
  }
  </style>