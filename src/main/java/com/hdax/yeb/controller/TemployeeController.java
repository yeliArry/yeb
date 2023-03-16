package com.hdax.yeb.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hdax.yeb.dao.TemployeeDao;
import com.hdax.yeb.dao.TemployeeecDao;
import com.hdax.yeb.dao.TsalaryDao;
import com.hdax.yeb.entity.Temployee;
import com.hdax.yeb.entity.Temployeeec;
import com.hdax.yeb.entity.Tsalary;
import com.hdax.yeb.service.TemployeeService;
import com.hdax.yeb.service.TsalaryAdjustService;
import com.hdax.yeb.util.R;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TemployeeController {
    @Resource
    private TemployeeDao temployeeDao;
    @Resource
    private TemployeeService temployeeService;
    @Resource
    private TsalaryAdjustService tsalaryAdjustService;
    @Resource
    private TsalaryDao tsalaryDao;
    @Resource
    private TemployeeecDao temployeeecDao;

    /**
     * 分页表联查
     *
     * @param currentPage
     * @param pageSize
     * @return
     */
    @RequestMapping("/temployee/query")
    public R query(@RequestParam(required = false, defaultValue = "1") int currentPage, @RequestParam(required = false, defaultValue = "10") int pageSize) {
        List<Temployee> list = temployeeService.query01(currentPage, pageSize);
        long total = temployeeService.getCount();
        return R.ok().data("list", list).data("total", total);
    }

    @RequestMapping("/temployee/query10")
    public R query10(@RequestParam(required = false, defaultValue = "1") int currentPage, @RequestParam(required = false, defaultValue = "10") int pageSize) {
        List<Temployee> list = temployeeService.query10(currentPage, pageSize);
        long total = temployeeService.getCount();
        return R.ok().data("list", list).data("total", total);
    }

    @RequestMapping("/temployee/get")
    public R get() {
        return R.ok().data("list", temployeeService.list());
    }

    @RequestMapping("/temployee/query02")
    public R query02() {
        return R.ok().data("list", temployeeService.list());
    }


    /**
     * 修改工资账套
     *
     * @param id
     * @param salaryId
     * @param cpage
     * @param pageSize
     * @return
     */
    @RequestMapping("/temployee/update")
    public R update(int id, int salaryId, int cpage, int pageSize) {

        temployeeDao.update01(id, salaryId);
        List<Temployee> list = temployeeService.query01(cpage, pageSize);
        long total = temployeeService.getCount();

        return R.ok().data("list", list).data("total", total).data("cpage", cpage);
    }


    /**
     * 新增方法
     *
     * @param temployee
     * @param
     * @param pageSize
     * @return
     */
    @RequestMapping("/temployee/save")
    public R save(Temployee temployee, int pageSize) {
        String s = temployee.getBirthday();
        s = s.split("T")[0];
        temployee.setBirthday(s);

        String b = temployee.getBeginDate();
        b = b.split("T")[0];
        temployee.setBeginDate(b);

        String c = temployee.getConversionTime();
        c = c.split("T")[0];
        temployee.setConversionTime(c);

        String e = temployee.getBeginContract();
        e = e.split("T")[0];
        temployee.setBeginContract(e);

        String f = temployee.getEndContract();
        f = f.split("T")[0];
        temployee.setEndContract(f);

        temployeeService.save(temployee);

        List<Temployee> list = temployeeService.query01(1, pageSize);
        long total = temployeeService.getCount();

        Page<Temployee> page = new Page<>(1, pageSize);
        IPage<Temployee> iPage = temployeeService.page(page);
        long pages = iPage.getPages();

        return R.ok().data("list", list).data("total", total).data("1", pages);

    }

    /**
     * 删除方法
     *
     * @param id
     * @param cpage
     * @param pageSize
     * @return
     */
    @RequestMapping("/temployee/del")
    public R del(int id, int cpage, int pageSize) {
        temployeeService.removeById(id);

        List<Temployee> list = temployeeService.query01(cpage, pageSize);
        long total = temployeeService.getCount();

        Page<Temployee> page = new Page<>(cpage, pageSize);
        IPage<Temployee> iPage = temployeeService.page(page);
        long pages = iPage.getPages();

        if (cpage > pages) {
            return R.ok().data("list", list).data("total", total).data("cpage", cpage - 1);
        } else {
            return R.ok().data("list", list).data("total", total).data("cpage", cpage);
        }
    }

    /**
     * 修改全部信息
     *
     * @param temployee
     * @param cpage
     * @param pageSize
     * @return
     */
    @RequestMapping("/temployee/update02")
    public R update02(Temployee temployee, int cpage, int pageSize) {
        if (temployee.getBirthday() == null) {
            temployee.setBirthday(null);
        } else {//如果得到的时间不等于空则修改
            String s = temployee.getBirthday();//修改时间的时候，因为时间类型的中间有T所以需要把这个T后面的东西去掉
            s = s.split("T")[0];
            temployee.setBirthday(s);
        }

        if (temployee.getBeginDate() == null) {
            temployee.setBeginDate(null);
        } else {
            String b = temployee.getBeginDate();
            b = b.split("T")[0];
            temployee.setBeginDate(b);
        }

        if (temployee.getConversionTime() == null) {
            temployee.setConversionTime(null);
        } else {
            String c = temployee.getConversionTime();
            c = c.split("T")[0];
            temployee.setConversionTime(c);
        }

        if (temployee.getNotWorkDate() == null) {
            temployee.setNotWorkDate(null);
        } else {
            String d = temployee.getNotWorkDate();
            d = d.split("T")[0];
            temployee.setNotWorkDate(d);

        }

        if (temployee.getBeginContract() == null) {
            temployee.setBeginContract(null);
        } else {
            String e = temployee.getBeginContract();
            e = e.split("T")[0];
            temployee.setBeginContract(e);
        }

        if (temployee.getEndContract() == null) {
            temployee.setEndContract(null);
        } else {
            String f = temployee.getEndContract();
            f = f.split("T")[0];
            temployee.setEndContract(f);
        }

        temployeeService.updateById(temployee);

        List<Temployee> list = temployeeService.query01(cpage, pageSize);
        long total = temployeeService.getCount();

        return R.ok().data("list", list).data("total", total).data("cpage", cpage);
    }

    /**
     * 批量删除
     *
     * @param myids
     * @param cpage
     * @param pageSize
     * @return
     */
    @RequestMapping("/temployee/dels")
    public R dels(String myids, int cpage, int pageSize) {
        String[] ss = myids.split("-");//拿到从前端得到的字符串
        List<Integer> ids = new ArrayList<>();//new一个集合
        for (int i = 1; i < ss.length; i++) {//循环拿到的字符串
            ids.add(Integer.parseInt(ss[i]));//把拿到的字符串转成int类型放到集合里
        }
        temployeeService.removeByIds(ids);//删除所拿到的所有id

        List<Temployee> list = temployeeService.query01(cpage, pageSize);
        long total = temployeeService.getCount();

        Page<Temployee> page = new Page<>(cpage, pageSize);
        IPage<Temployee> iPage = temployeeService.page(page);
        long pages = iPage.getPages();

        if (cpage > pages) {
            return R.ok().data("list", list).data("total", total).data("cpage", cpage - 1);
        } else {
            return R.ok().data("list", list).data("total", total).data("cpage", cpage);
        }
    }


    @RequestMapping("/temp/daoru")
    public R importEmployee(MultipartFile file) {
        //新建一个类放数据
        ImportParams params = new ImportParams();
        //将这个Excel去掉标题行
        params.setTitleRows(1);
        try {
            //从文件中提取数据放入到集合中
            List<Temployee> list = ExcelImportUtil.importExcel(file.getInputStream(), Temployee.class, params);
            //然后将数据进行对比
            if (temployeeService.saveBatch(list)) {
                return R.ok();
            }
        } catch (Exception e) {//响应异常
            e.printStackTrace();
        }
        return R.error();
    }

    @RequestMapping(value = "/temp/daochu", produces = "application/octet-stream")
    public void daochu(HttpServletResponse response) {
        //从数据库查出所有要导出的数据
        List<Temployee> list = temployeeService.query02();
        //导出参数
        ExportParams params = new ExportParams("员工表", "员工表", ExcelType.HSSF);
        //创建工作簿，把得到的Temployee类以excel形式导出到员工表
        Workbook workbook = ExcelExportUtil.exportExcel(params, Temployee.class, list);
        //创建一个输出流
        ServletOutputStream out = null;
        try {
            //流行式
            response.setHeader("content-type", "application/octet-stream");
            //防止中文乱码
            response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode("员工表.xls", "UTF-8"));
            //把得到的员工表放到输出流中
            out = response.getOutputStream();
            //将得到的输出流放到工作薄中
            workbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != out) {//如果输出流不为空则关闭
                try {
                    out.close();
                } catch (IOException e) {//响应异常
                    e.printStackTrace();
                }
            }
        }

    }

    @RequestMapping("/tem/getMoneyById")
    public R getMoneyById(int id) {
        return R.ok().data("list", temployeeDao.getMoneyById(id));
    }

    @RequestMapping("/tem/query03")
    public R query03(@RequestParam(required = false, defaultValue = "1") int currentPage, @RequestParam(required = false, defaultValue = "5") int pageSize) {


        List<Temployeeec> list1 = new ArrayList<>();
        List<Temployee> list = temployeeService.query03(currentPage, pageSize);
        for (Temployee temployee : list) {
            Tsalary tsalary = tsalaryDao.selectById(temployee.getSalaryId());
            if (temployee.getTsalaryAdjust() != null) {
                int sum1 = temployee.getTsalaryAdjust().getAfterSalary() + temployee.getTsalary().getBonus() + temployee.getTsalary().getLunchSalary() + temployee.getTsalary().getTrafficSalary();

                temployee.getTsalary().setAllSalary(sum1);

            } else {
                int sum = temployee.getTsalary().getBasicSalary() + temployee.getTsalary().getBonus() + temployee.getTsalary().getLunchSalary() + temployee.getTsalary().getTrafficSalary();

                temployee.getTsalary().setAllSalary(sum);

            }

//            int sum1 = temployee.getTsalary().getBasicSalary()+temployee.getTsalary().getBonus()+temployee.getTsalary().getLunchSalary()+temployee.getTsalary().getTrafficSalary();
//            temployee.getTsalary().setAllSalary(sum1);

            if (temployee.getTemployeeec() != null && temployee.getTemployeeec().size() > 0) {
                list1 = temployee.getTemployeeec();
                for (Temployeeec ec : list1) {
                    if (temployee.getTemployeeec() != null) {
                        System.out.println("我进来加了");
                        int sum = temployee.getTsalary().getAllSalary();
                        if (ec.getEcType() == 0) {
                            int jia = sum + ec.getEcPoint();
                            temployee.getTsalary().setAllSalary(jia);
                            System.out.println("计算后的工资：" + jia);
                            System.out.println(jia + "-------------------");
                        } else if (ec.getEcType() == 1) {
                            int jian = sum - ec.getEcPoint();
                            temployee.getTsalary().setAllSalary(jian);
                            System.out.println("计算后的工资：" + jian);
                        }
                    }
                }
            }


        }
        //List<Temployee> list1 = temployeeService.query03(currentPage, pageSize);
        long total = temployeeService.getCount();
        return R.ok().data("list", list).data("total", total);
    }

    //奖罚
    @RequestMapping("/tem/queryAll")
    public R queryAll(int id) {
        List<Temployeeec> list = temployeeecDao.queryEid(id);
        return R.ok().data("list", list);
    }


    //高级搜索
    @RequestMapping("/t_employee/gaoquery")
    public R gaoquery(String name, String politicId, String nationId, String departmentId, String jobLevelId, String posId, String engageForm, @RequestParam(required = false, defaultValue = "1") int currentpage, @RequestParam(required = false, defaultValue = "5") int pageSize) {
        int a = 0;//政治面貌
        if (politicId != null && !"".equals(politicId)) {
            a = Integer.parseInt(politicId);
        }
        int b = 0;//名族
        if (nationId != null && !"".equals(nationId)) {
            b = Integer.parseInt(nationId);
        }
        int c = 0;//名族
        if (departmentId != null && !"".equals(departmentId)) {
            c = Integer.parseInt(departmentId);
        }
        int d = 0;
        if (jobLevelId != null && !"".equals(jobLevelId)) {
            d = Integer.parseInt(jobLevelId);
        }
        int e = 0;
        if (posId != null && !"".equals(posId)) {
            e = Integer.parseInt(posId);
        }

        List<Temployee> list = temployeeService.gaoquery(name, a, b, c, d, e, engageForm, currentpage, pageSize);
        long total = temployeeService.gaoqueryCount(name, a, b, c, d, e, engageForm);
        return R.ok().data("total", total).data("list", list).data("currentpage", currentpage);
    }


}
