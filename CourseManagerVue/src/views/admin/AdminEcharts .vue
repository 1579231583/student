  <template>
    <div ref="chart" style="width: 600px; height: 400px;"></div>
  </template>
  
  <script>
  import * as echarts from 'echarts';
  import * as api from "../../api/admin/echarts";
  export default {
    data() {
        return {
            echartData:[]
        };
    },
    mounted() {
      this.getlist();
    },
    methods: {
     getlist(){
        api.list().then((res) => {
        console.log("111111111",res)
        const chart = echarts.init(this.$refs.chart);
        chart.setOption({
        
        title: {
        text: '学生成绩柱状图',
        left: 'center', 
        textStyle: {
          fontSize: 18, 
          fontWeight: 'bold' 
        }
      },
          tooltip: {},
          
          xAxis: {
    type: 'category',
    data: res.studentName
  },
  yAxis: {
    type: 'value'
  },
  series: [
    {
      data: res.scores,
      type: 'line'
    }
  ]
        });
      });
    }
  }
}
</script>
