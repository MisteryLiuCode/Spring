package com.liu.spring.di;

public class DiImpl {
    private DiDao diDao;

    public DiDao getDiDao() {
        return diDao;
    }

    public void setDiDao(DiDao diDao) {
        this.diDao = diDao;
    }

    public void diTest(){
        System.out.println("DiImpl方法执行");
        System.out.println("diDao对象为"+diDao);
        diDao.diDao();
    }
}
