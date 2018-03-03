package com.tulu.employee.dashboard.EmployeeDashboardService.controller;


import com.tulu.employee.dashboard.EmployeeDashboardService.domain.model.EmployeeInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@FeignClient(name = "EmployeeSearch")
@RibbonClient(name = "EmployeeSearch")
public interface EmployeeServiceProxy {
    @RequestMapping("/employee/find/{id}")
    public EmployeeInfo findById(@PathVariable(value = "id") Long id);
    @RequestMapping("/employee/findall")
    public Collection<EmployeeInfo> findAll();
}
