/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.chou.mathutil.core;

import static com.chou.mathutil.core.MathUtil.getFactorial;
//import static là dành cho hàm static riêng, gọi hàm bỏ qua tên class
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 *
 * @author Admin
 */
public class MathUtilTest {

    //dùng DDT, tách data ra khỏi câu lệnh kiểm thử, tham số hóa dât
    //chuẩn bị bộ data
    public static Object[][] initData() {
        return new Integer[][]{
            {1, 1},
            {2, 2},
            {5, 120},
            {6, 720}

        };
    }

    @ParameterizedTest
    @MethodSource(value = "initData") //tên hàm cung cấp data, ngầm định thứ  tự
    //của cá phần tử trong mảng, map vào tham số hàm 
    public void testGetFactorialGivenRightArgReturnWell(int input, long expected) {
        assertEquals(expected, getFactorial(input));
    }
//    @Test
//    public void testGetFactorialGivenRightArgReturnWell() {
//        assertEquals(24, getFactorial(4));
//    }

    //kiểm thử bằng ngoại lệ
    @Test
    public void testGetFactorialGivenWrongArgThrowException() {
        //dùng biểu thức lambda
        //hàm nhận tham số thứ 2 là 1 object/có code implement cái
        //functional interface tên là executable - có 1 hàm duy nhất k có code
        //tên là execute()
//        
//        Executable excObject = new Executable() {
//            @Override
//            public void execute() throws Throwable {
//                getFactorial(-5);
//            }
//        };
//        Executable excObject = () -> {
//            getFactorial(-5);
//        };
        assertThrows(IllegalArgumentException.class, () -> {
            getFactorial(-5);
        });
    }

}
