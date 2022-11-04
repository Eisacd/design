package com.lp.entity.vo;

import com.lp.entity.User;
import com.lp.entity.Wage;
import lombok.Data;

@Data
public class WageVo extends Wage {
    private User wageUser;
}
