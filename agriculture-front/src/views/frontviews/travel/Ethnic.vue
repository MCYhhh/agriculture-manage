<template>
  <div class="articleContent" >
    <div class="back" @click="backgame">
      <i class="el-icon-d-arrow-left" style="font-size: 25px;color: #999999;" ></i>
      <span style="font-size: 22px;color:#e0dddd;" >返回</span>
    </div>
    <div style="text-align: center;font-weight: bold;font-size: 28px ">------民俗民风------</div>
    <p class="images">
      <div style="width: 679px;display: inline-block;margin-left: 200px;">
      <transition name="el-zoom-in-top">
        <img class="big" src="../../../assets/images/yunnan7.jpg" v-show="show2">
      </transition>
      <p class="image1">元阳梯田</p>
  </div>
      <div class="group">
        <div>
      <transition  name="el-zoom-in-top">
        <img class="smalla" src="../../../assets/images/yunnan2.jpg" v-show="show2">
      </transition>
          <p class="image2">民族刺绣背衫</p>
        </div>

        <div>
      <transition   name="el-zoom-in-top">
        <img class="smalla" src="../../../assets/images/yunnan5.jpg" v-show="show2">
      </transition>
          <p class="image3">普洱茶田</p>
        </div>

      <transition   name="el-zoom-in-bottom">
        <img class="smallb"  src="../../../assets/images/yunnan1.jpg" v-show="show2">
      </transition>
      <transition  name="el-zoom-in-bottom">
        <img class="smallb" src="../../../assets/images/yunnan4.jpg" v-show="show2">
      </transition>
      </div>
<!--    <hr style="margin-top:40px ;margin-left: 500px">-->
    <el-divider></el-divider>
    <p style="text-align: center;margin-left: 500px;color:#070756;">神奇美丽的自然风光，绚丽多姿的民族风情等，总有一个让你来云南的理由!</p>
    <div class="demo-image__placeholder" style="margin-left:560px;margin-bottom: 15px;margin-top: -5px">
      <el-card class="frontimages"><img class="fimages" src="../../../assets/images/yunnan15.jpg" style="width: 260px;  "><p class="description">大理的农耕</p></el-card>
      <el-card class="frontimages"><img class="fimages" src="../../../assets/images/yunnan17.jpg" style="width: 260px;  "><p class="description">丽江泸沽湖摩梭族篝火晚会</p></el-card>
      <el-card class="frontimages"><img class="fimages" src="../../../assets/images/yunnan18.jpg" style="width: 260px;  "><p class="description">跳神</p></el-card>
      <el-card class="frontimages"><img class="fimages" src="../../../assets/images/yunnan14.jpg" style="width: 260px;  "><p class="description">哈尼族女性传统服饰</p></el-card>
    </div>
    <div class="recommendation">
      <el-link style="margin-top: 15px;font-weight: bold;color:green;font-size: 16px">来云南一定要做的事</el-link>
      <p style="margin-top: -5px;color:green;">--------------------------</p>
      <el-link :underline="false" type="info" style="display: block;font-size: 15.9px;margin-bottom:5px;color:black;">找个地方看云</el-link>
      <el-link :underline="false" type="info" style="display: block;font-size: 15.9px;margin-bottom:5px;color:black;">去西双版纳淘一块普洱茶</el-link>
      <el-link :underline="false" type="info" style="display: block;font-size: 15.9px;margin-bottom:5px;color:black;">吃一次正宗的过桥米线</el-link>
      <el-link :underline="false" type="info" style="display: block;font-size: 15.9px;margin-bottom:5px;color:black;">环游一次洱海</el-link>
      <p style="font-weight: bold;">... ... ... ...</p>
    </div>
    <div class="recommendation1">
      <el-link style="margin-top: 15px;font-weight: bold;color:green;font-size: 16px">民族节日</el-link>
      <p style="margin-top: -5px;color:green;">--------------------------</p>
      <el-link :underline="false" type="info" style="display: block;font-size: 15.9px;margin-bottom:5px;color:black;">彝族:火把节(农历六月二十五日)</el-link>
      <el-link :underline="false" type="info" style="display: block;font-size: 15.9px;margin-bottom:5px;color:black;">大理白族:三月三(农历三月十五日至二十一日)</el-link>
      <el-link :underline="false" type="info" style="display: block;font-size: 15.9px;margin-bottom:5px;color:black;">丽江纳西族:三朵节(农历二月八)</el-link>
      <el-link :underline="false" type="info" style="display: block;font-size: 15.9px;margin-bottom:5px;color:black;">傈僳族:阔时节(农历十二月初五到第二年正月初十)</el-link>
      <el-link :underline="false" type="info" style="display: block;font-size: 15.9px;margin-bottom:5px;color:black;">摩梭人:转山节(农历七月二十五日)</el-link>
      <el-link :underline="false" type="info" style="display: block;font-size: 15.9px;margin-bottom:5px;color:black;">傣族、德昂族:泼水节(四月中旬左右)</el-link>
      <el-link :underline="false" type="info" style="display: block;font-size: 15.9px;margin-bottom:5px;color:black;">怒族:仙女节(农历三月十五日)</el-link>
      <el-link :underline="false" type="info" style="display: block;font-size: 15.9px;margin-bottom:5px;color:black;">景颇族:目瑙纵歌节(农历正月十五以后的九天内择双日)</el-link>
      <el-link :underline="false" type="info" style="display: block;font-size: 15.9px;margin-bottom:5px;color:black;">哈尼族:姑娘节(农历二月初四)</el-link>
      <el-link :underline="false" type="info" style="display: block;font-size: 15.9px;margin-bottom:5px;color:black;">佤族:拉木鼓节(农历十一月-佤历一月)</el-link>

      <p style="font-weight: bold;">... ... ... ...</p>
<!--      <p style="font-weight: bold;color:green">来云南一定要做的事</p>-->
<!--      <p style="margin-top: -15px;color:green">&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;</p>-->
<!--      <p>找个地方看云</p>-->
<!--      <p>去西双版纳淘一块普洱茶</p>-->
<!--      <p>吃一次正宗的过桥米线</p>-->
<!--      <p>环游一次洱海</p>-->
<!--      <p style="font-weight: bold;">... ... ... ...</p>-->
    </div>
    <el-divider></el-divider>
    <div class="description">
      <p style="margin-left: 140px;font-size: 20px">云南境内少数民族主要有彝族、哈尼族、白族、傣族、壮族、苗族、回族、傈僳族、拉祜族佤族、纳西族、景颇族、布朗族、普米族、阿昌族、怒族、基诺族、德昂族、独龙族等25个。 云南是我国民族种类最多的省份。</p>
    </div>
    <div class="homeleft-container">


      <el-card style="width: 60%;">
        <div class="demo-image__preview" v-for="(item,index) in news" :key="item.id" >
          <el-image
            style="width: 100px; height: 100px;margin-bottom: -40px;padding-top: 10px"
            :src="item.url"
            :preview-src-list="item.srcList"
          >
          </el-image>
          <div class="content">
            <p>
              <span>{{item.site}}</span>
<!--              <el-divider direction="vertical"></el-divider>-->
<!--              <span>{{item.type}}</span>-->
            </p>
            <p >
              <el-tag>摘要</el-tag>
              {{item.abstarct}}
            </p>
            <p >
              <el-tag  type="warning">正文</el-tag>
            </p>
            <div class="zhengwen">{{item.content}}</div>

            <div class="itemrate">
              <p style="position: relative;top: -25px;left:500px">
                <el-link type="success" style="margin-left: 200px;color:green;">@悦享滇韵</el-link>
                <i class="el-icon-d-arrow-right" style="margin-left: 50px;" ></i>
                <span style="font-size: 15px;color:green;" @click="detail(item.id)">了解更多</span>
                <!--              <span class="date"><i class="el-icon-date" style="margin-left: 20px">{{item.create_time}}</i></span>-->

              </p>
              <!--          <span>@{{item.uname}}</span>-->
              <!--            <el-button type="primary" class="browse">查看详情</el-button>-->
            </div>
            <el-divider class="divide"></el-divider>
          </div>
          </div>

        <div class="block">
          <el-pagination
            @size-change="handleSizeChange"
            @current-change="handleCurrentChange"
            :current-page="currentPage4"
            :page-sizes="[2, 4, 6, 8]"
            :page-size="4"
            layout="total, sizes, prev, pager, next, jumper"
            :total="453">
          </el-pagination>
        </div>
      </el-card>

    </div>
    </div>

</template>

<script>
export default {
  data()  {
    return{


      news:[
        {
          id:1,
          url:'https://www.dalitravel.cn/upload/image/202003/03/4dbeac24bbc022d252d48f762dc0b789.jpg',
          srcList:['https://www.dalitravel.cn/upload/image/202003/03/4dbeac24bbc022d252d48f762dc0b789.jpg','https://www.dalitravel.cn/upload/image/202003/03/4940c6fa36399efde31106256637df5d.jpg'],
          site:'大理白族蝴蝶会',
          abstarct:'蝴蝶会是大理白族民间一个人与自然亲密无间，共享美好春光的游乐盛会，于每年农历四月十五日在点苍山云弄峰脚下的蝴蝶泉边举行',
          content:'蝴蝶会是大理白族民间一个人与自然亲密无间，共享美好春光的游乐盛会，于每年农历四月十五日在点苍山云弄峰脚下的蝴蝶泉边举行。\n' +
            '蝴蝶泉以崖下喷涌四季不竭的泉水，泉边古树聚满五彩缤纷的彩蝶而得名。天然妙景，遐迩闻名。360多年前，大旅行家徐霞客曾描写道：“有蛱蝶泉之异，余闻之已久。”“泉上大树，当四月初即发花如蛱蝶，须翅栩然，与生蝶无异。还有真蝶千万，连须钩足，自树巅倒悬而下及于泉面，缤纷络绎，五色焕然。游人俱以此月，群而观之，过五月乃已。”其中所描写的泉上大树至今犹存，是一种花似蝴蝶的合欢树。泉边浓荫蔽日，全是酸香树、黄连木等芳香树种，清香扑鼻。树荫之下，又遍布着山茶、杜鹃、蔓陀萝、月月红等奇花异卉，方圆百亩，成了一个蝶舞蜂狂的世界。每年三、四月间，正是蝴蝶在此聚会的佳期，犹以四月十五日最盛，当地白族青年男女便相约来此聚会，赏蝶观景，唱曲对歌，谈情说爱，老年人也在此相聚谈演洞经古乐，祈祷风调雨顺，成了一年一度的蝴蝶会。关于蝴蝶泉的由来，白族民间流传着许多美丽的传说。蝴蝶泉原名无底潭，潭后的云弄峰神摩山中盘踞着一条恶蟒。它可以忽而变作猛虎，忽而变作人形，经常下山吞食人畜、淫乱妇女，百姓苦不堪言。一日，有位名叫杜朝选的英雄猎人来到这里，得知恶蟒危害村民，便独自潜入山中，发箭射伤恶蟒。恶蟒逃跑后，第二天，杜朝选又再次跟踪追寻，在霞移溪口遇见两个姑娘在洗血衣，得之她们正是被恶蟒化作美少年骗进洞中供其淫乐的姑娘，所洗血衣正是中箭的蟒皮所变。于是，在二位姑娘的指引下，猎人深入洞中与恶蟒搏斗，终于杀死恶蟒，救出两位姑娘。两位姑娘对杜朝选感激、爱慕不已，决定以终身相许，不想却被杜朝选谢绝，于是二人悄悄跳入了无底潭。杜朝选得知情由，后悔莫及，也纵身跳入潭中殉情。三人均化为彩蝶翩飞于潭水之上，引来各方蝴蝶纷纷前来凭吊，从此无底潭便成了蝴蝶泉。此传说千古流传民间，杜朝选还被当地周城村奉为本主。两位姑娘同时被奉为本主夫人，他们的塑像都供奉在本主庙内供世人朝拜。\n' +
            '蝴蝶泉是一个象征爱情忠贞的泉眼，蝴蝶会也自然成为白族青年追求爱情幸福的盛会。',
          create_time:'2019-11-03',
          uname:'@大理旅游网'
        },
        {
          id:2,
          url:'http://n.sinaimg.cn/sinacn00/130/w585h345/20180923/56b2-hiixpup5485895.jpg',
          srcList:['http://n.sinaimg.cn/sinacn00/130/w585h345/20180923/56b2-hiixpup5485895.jpg','https://ts1.cn.mm.bing.net/th/id/R-C.37e7eeb464566af4842c8703fb753596?rik=MSkJyFpwpe9ILA&riu=http%3a%2f%2fpic.baike.soso.com%2fp%2f20131210%2f20131210125358-1448039314.jpg&ehk=RFJ7okCK7jsIVei3aEuTEvNLuXMoWul%2bUwKwjiQovb8%3d&risl=&pid=ImgRaw&r=0'],
          site:'傣族服饰',
          abstarct:'傣族是云南省特有的少数民族，主要分布于云南省南部和西部的河谷平坝地区。西双版纳傣族自治州和德宏傣族，景颇族自治州是傣族主要的居住区。傣族服饰淡雅美观，既讲究实用，又有很强的装饰意味，颇能体现出热爱生活，崇尚中和之美的民族个性。',
          content:'傣族是云南省特有的少数民族，主要分布于云南省南部和西部的河谷平坝地区。西双版纳傣族自治州和德宏傣族，景颇族自治州是傣族主要的居住区。傣族生活的地方，都是热带、亚热带地区，那里气候温热，山林茂密、物产丰富。傣族服饰也就充分体现了这些地理特点，淡雅美观，既讲究实用，又有很强的装饰意味，颇能体现出热爱生活，崇尚中和之美的民族个性，和民间习俗。\n'+
          '傣族服饰淡雅美观，既讲究实用，又有很强的装饰意味，颇能体现出热爱生活，崇尚中和之美的民族个性。各地男子的服饰差别不大，一般常穿无领对襟或大襟小袖短衫，下着长管裤，以白布、水红布或蓝布包头。傣族妇女的服饰，因地区而异。西双版纳的傣族妇女上着各色紧身内衣，外罩紧无领窄袖短衫，下穿彩色统裙，长及脚面，并用精美的银质腰带束裙；德宏一带的傣族妇女，一部分也穿大统裙短上衣，色彩艳丽，一部分(如潞西、盈江等地)则穿白色或其它浅色的大襟短衫，下着长裤，束一绣花围腰，婚后改穿对襟短衫和统裙；新平、元江一带的“花腰傣”，上穿开襟短衫，着黑裙，裙上以彩色布条和银泡装饰，缀成各式图案，光彩耀目。各种傣族妇女服饰均能显出女性的秀美窈窕之姿。傣族妇女均爱留长发，束于头顶，有的以梳子或鲜花为饰，有的包头巾，有的戴高筒形帽，有的戴一顶尖顶大斗笠，各呈其秀，各显其美，颇为别致。\n'+
          '富于热带、亚热带旖旎风光的傣族服饰，也是独具民族特色的。傣族男子一般喜穿无领对襟或大襟小袖短衫，下着长管裤，多用白布、永红布或蓝布包头。普遍有纹身的习俗，作为身体装饰美的组成部分。花纹有虎、豹、象、狮、龙、蛇等动物或经文、八卦、线条等图案。妇女服饰，因地区而异。德宏一带傣族妇女，婚前多穿浅色大襟短衫，下穿长裤，束一小围腰，婚后穿对襟短衫，花色或黑色统裙。西双版纳的傣族妇女上着白色、绊色或天蓝色等紧身内衣，大襟或对襟圆领窄袖衫，下身多为花色长统裙。各地的傣族妇女均很讲究发饰。青年妇女多结发于头顶，也有束发垂脑后的。平日多于发上扎以帕或插梳子，天冷则顶花头巾。若逢节日喜庆，姑娘们尤爱在发会上插缀鲜花并洒香水，再穿上用绸缎、尼龙、灯芯绒、金丝绒等缝制的精美衣裙，盛装打扮，更感妩媚。每遇河边井旁沐浴之后，身材纤细。苗条的傣族少女，将黑亮的发髻盘于脑后，在紧身短衫和花统裙之间扣上银腰带，亭亭玉立，宛如古典仕女的风韵。\n',
          create_time:'2018-10-05',
          uname:'@baidu'
        },
        {
          id:3,
          url:'https://tse2-mm.cn.bing.net/th/id/OIP-C.wHKTU6-M5ARoI0dRTMlIVAHaFz?pid=ImgDet&rs=1',
          srcList:['https://tse2-mm.cn.bing.net/th/id/OIP-C.wHKTU6-M5ARoI0dRTMlIVAHaFz?pid=ImgDet&rs=1','https://x0.ifengimg.com/res/2021/EBDD1C42DD8877020E4405CFC19E71BAD3DE529D_size1253_w693_h462.png'],
          site:'火把节',
          abstarct:'火把节（彝族火把节），流行于云南、贵州、四川等彝族地区的传统节日，国家级非物质文化遗产之一。火把节的起源与人们对火的崇拜有关，其目的是期望用火驱虫除害，保护庄稼生长。',
          content:'火把节（彝族火把节），流行于云南、贵州、四川等彝族地区的传统节日，国家级非物质文化遗产之一。\n' +
            '火把节的起源与人们对火的崇拜有关，其目的是期望用火驱虫除害，保护庄稼生长。火把节期间，各村寨以干松木和松明子扎成大火把竖立寨中，各家门前竖起小火把，入夜点燃，村寨一片通明；同时人们手持小型火把绕行田间、住宅一周，将火把、松明子插于田间地角。青年男女在寨中大火把周围弹唱、跳舞，彻夜不息。节日期间，还有赛马、斗牛、射箭、摔跤、拔河、荡秋千等娱乐活动，并开设贸易集市。\n' +
            '2006年5月20日，四川省凉山彝族自治州、云南省楚雄彝族自治州申报的火把节（彝族火把节）经中华人民共和国国务院批准列入第一批国家级非物质文化遗产名录。 2011年6月9日，贵州省赫章县申报的火把节（彝族火把节）经中华人民共和国国务院批准列入第三批国家级非物质文化遗产名录。遗产编号：Ⅹ-10。彝族火把节的起源，追溯其根源就是来自于彝族先民对火的原始崇拜。\n' +
            '首先从彝族居住的地理环境来看。彝族主要分布于金沙江两岸的凉山、乌蒙山、哀牢山等高寒山区，对火的依赖比其他民族更强。火是人们照明取暖熟化食物的必不可少的生活资料。在生产上，用火将埋藏在地中的树枝树叶堆引燃，使其燃烧，使土地肥沃。人们生产生活都离不开火，由于彝族人民对火的依赖性强，在意识形态上，火对彝族的影响也就更大些。\n' +
            '其次从彝族的原始宗教活动仪式来看。每次的原始宗教活动都是以在屋内或门外燃火堆，借以呼唤火神为开始。火在彝族原始宗教活动意识中占据非常重要的地位，以致通常人们在社会生活中处处显示出敬火的意识。\n' +
            '再次从彝族的社会生活习俗中来看。每家在进人新房前都须先烧红一块石头，再摘一些苦蒿苗装进瓜瓢里，放进少许水，把烧红的石头丢进瓢中，再围绕屋内四角以示驱祛所有污秽，然后主人才全部进入屋内。凉山彝族谚语说“所吃的都要见火”般从屋外拿回家的畜肉或兽肉，进屋前都必须在门外燃小堆火，将拿回的畜兽肉在火上熏后才能进屋，以示驱秽。新媳妇进屋前也在门口燃小堆火使其从上面跨过才能进屋，也是以示驱秽。\n'+
            '彝族火把节一般历时三天三夜，分为祭火、玩火、送火三个阶段。',
          create_time:'2022-02-19',
          uname:'@baidu'
        },
        {
          id:4,
          url:'http://cn.iyunnan.travel/files/mzms%201.jpg',
          srcList:['http://cn.iyunnan.travel/files/mzms%201.jpg','http://cn.iyunnan.travel/files/mzms%2014.jpg'],
          site:'云南少数民族特色美食',
          abstarct:'在云南这片广阔的土地上，生活着25个少数民族，因为这里得天独厚的自然资源，因为聪明智慧的少数民族同胞，也因为美食的欲望，在云南少数民族的聚集地，可以品尝到每个民族独有的美食。',
          content:'在哈尼族招待外来的客人的餐桌上，必不会少了竹筒鸡这道美食。云南盛产竹子，竹筒烹饪，历史久远。智慧的人们利用中空的竹子来绘制美食，竹筒内加入食物，一种由内而发的清香会混合进食物中，产生独特的口感，深受爱吃一族的喜爱，久而久之，这道美食加入烹调技巧，代代相传，自成美味。\n'+
            '傣族是一个历史悠久的民族，火烧干巴作为时间的传承物，因其香味独特，做法独到，储存便宜等特点，深受傣族人民的喜受。傣族火烧干巴的吃法不复杂，不加任何辅料，撕开肉丝即可食用。刚烧出来的干巴，香且脆，味匀，现烤现吃味道更甚。\n'+
            '“生皮”不仅是大理的一道传统菜肴，还是白族饮食文化中的一道传奇。逢年过节或者日常待客,白族人总会以“皮”作为自已的招牌菜特色菜,犒劳自己和款待来宾。从南诏时期，开始，白族就有吃“生皮”的习惯，并一直延续至今，凡是有白族人聚居的地方，一定有人吃“生皮”。白族人所吃的生皮，是用稻草火烧去毛，故有“白族火烧猪”的美誉。\n'+
          '阿昌族大部分聚居在云南，是中国云南境内最早的世居民族之一。阿昌族人在栽秧时将鱼苗放入田内，谷熟后取鱼，称谷花鱼。酸辣谷花鱼是将谷花鱼油炸或煎制，然后放入酸辣椒和水煮熟就可以食用了。谷花鱼酸辣嫩滑，味道鲜美，深受喜爱。阿昌族人也喜吃饵丝、米线、芋头等，在庆祝节日、丰收的时候，一定离不开它们。\n'+
          '纳西族，“纳”有大或尊贵之意，“西”意为人。勤劳节俭的纳西人，喜欢喝酒、饮浓茶，爱吃酸、辣，甜味的食品。火腿粑粑是纳西族美食中最受欢迎的一种，将发酵面团擀制成饼坯，撒火腿末，两头拉拢包上果仁甜馅，放在平底锅内油煎而成。火腿粑粑色泽金黄，多层相叠，外脆里嫩，喷香酥脆。\n'+
          '云南的美食真令人咂舌，滇味以少数民族的口味为基础，兼容了川、渝的酸、香、辣后形成，美味非一般。体验不一样的风情，体验不一样的美食，在云南！',
          create_time:'2022-01-19',
          uname:'@云南旅游网'
        }
      ],
      value: 0,
      switch1: false,
      switch2: false,
      option: [
        { text: '全部文章', value: 0 },
        { text: '娱乐趣谈', value: 1 },
        { text: '游记探寻', value: 2 },
      ],




      show2: false,
      images:{
        srcList: ['https://www.dalitravel.cn/upload/image/202003/03/1565a37247d0e3d02a3d669824184b50.jpg','../../../assets/images/yunnan1.jpg','https://p1-q.mafengwo.net/s16/M00/BF/21/CoUBUmEuN4WAQpEBABmrddaOMac200.jpg?imageView2%2F2%2Fw%2F1360%2Fq%2F90','https://p1-q.mafengwo.net/s16/M00/BF/40/CoUBUmEuN8qAaTXiADTR163bpk4906.jpg?imageView2%2F2%2Fw%2F1360%2Fq%2F90','https://p1-q.mafengwo.net/s16/M00/BF/38/CoUBUmEuN7OAZoqOABXLo0Rl8cw563.jpg?imageView2%2F2%2Fw%2F1360%2Fq%2F90'],
      }
    }
  },
  name: "Ethnic",
  methods:{
    detail(nid){
      this.news.some((item,index)=>{
        console.log(item)
        if(item.id===nid){
          console.log("拿到拿到")
          localStorage.setItem('item',JSON.stringify(item))

        }
      })
      // console.log(id);
      // localStorage.setItem("item",item)
      this.$router.push("/front/detail")
    },
    backgame(){
      this.$router.push('/front/travel')
    }
  },
  mounted() {
    this.show2 = true;
  }
}
</script>

<style scoped>
.zhengwen{
  /*width: 715px; !* (一定要加宽度）*!*/
  text-overflow: ellipsis; /* 溢出用省略号 */
  white-space: nowrap; /*溢出不换行 */
  -webkit-line-clamp: 1;  /*控制显示的行数 */
  -webkit-box-orient:vertical;
  overflow:hidden; /*超出的文本隐藏 */
}
.articleContent{
  /*background-image: url('../../../assets/images/yunnan8.png');*/
  /*background-repeat: no-repeat;*/
  /*background-opacity: 0.5*/
}
.description{
  /*width:1px;*/
  /*text-align: center;*/
}
.demo-image__placeholder{
  /*width:1000px;*/
}
.frontimages{
  width:300px;
  height:260px;
  display: inline-block;
  margin-right: 30px;
  margin-bottom: 10px;
  /*padding-right: px;*/
  background-color: #F6EEE8FF;

}
.fimages :hover{
  width: 270px;
  /*height: 260px;*/
}
.el-icon-s-operation{
  font-size: 30px;
  color: #6096a8;

}
.images{
  margin-left: 200px;
  margin-top: 50px;
  /*background-image: url("");*/
}

.big{
  height:450px;
}
.group{
  position: static;
  float: right;
  width:600px;
}
.smalla{
  /*display: inline-block;*/
  float:left;
  height:225px;
  position: relative;
  left: -400px;
}
.smallb{
  /*display: inline-block;*/
  position: relative;
  height:225px;
  top:-450px;
  left: -60px;
  /*margin-top: 225px;*/

}
.image1{
  background-color: rgb(0,0,5);
  opacity: 0;
  position:absolute;
  width:674px;
  height:60px;
  margin-top: -63px;
  color:white;
  text-align: center;
}
.image1:hover{
  opacity: 0.7;
}
.image2{
  background-color: rgb(0,0,5);
  opacity: 0;
  width:337px;
  height:50px;
  margin-left: -400px;
  position: absolute;
  margin-top: 174px;
  color:white;
  text-align: center;
}
.image2:hover{
  /*background-color: rgb(0,0,5);*/
  opacity: 0.7;
}
.image3{
  background-color: rgb(0,0,5);
  opacity: 0;
  width:337px;
  height:50px;
  position: absolute;
  color:white;
  margin-left: -400px;
  margin-top: 400px;
  text-align: center;
}
.image3:hover{
  opacity: 0.7;
}
.recommendation{
  background: #f4ece7;
  float: right;
  margin-right: 100px;
  margin-top: -500px;
  width: 400px;
  border-radius: 9px;
  text-align: center;
}
.recommendation1{
  background: #f4ece7;
  float: right;
  margin-right: 100px;
  margin-top: 120px;
  width: 400px;
  border-radius: 9px;
  text-align: center;
}

.el-zoom-in-top-enter-active{
  transition:0.8s linear;
}
.el-zoom-in-bottom-enter-active{
  transition:0.8s linear;
}


.demo-image__preview{
  /*margin-top: -30px;*/
  height: 240px;
}

.homeleft-container{
  /*background-size: cover;*/
  /*width: 992px;*/
  /*margin:-150px 0 0 180px;*/
  /*width: 2000px;*/
  margin-left: 225px;
}
.content{
  position: relative;
  left: 120px;
  top:-75px;
  width: 75%;
}
span{
  font-weight: bold;
}
/deep/ .van-popup--top{
  width: 20%;
}
.divide{
  margin-top: -30px;
}
.itemrate {
  position: static;
  margin-top: 40px;
  margin-left: -110px;
}
.itemrate .el-rate{
  position: relative;
  top:-25px
}
.itemrate .browse{
  position: relative;
  top:-65px;
  left:800px
}




</style>






























