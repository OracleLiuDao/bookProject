package com.liudao.dao.impl;

import com.alibaba.druid.util.JdbcUtils;
import com.liudao.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author:liudao
 * @company:null
 * @date: 2020/3/1 - 22:08
 */
//给别人复用代码的,不许要对象实例
public abstract class BaseDao {
    private QueryRunner queryRunner = new QueryRunner();

    public  int update(String sql,Object... ages){
       /* Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
           return queryRunner.update(conn,sql,ages);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;*/
        System.out.println(" BaseDao 程序在[" +Thread.currentThread().getName() + "]中");

        Connection connection = JDBCUtils.getConnection();
        try {
            return queryRunner.update(connection, sql, ages);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

        public <T> T queryForOne(String sql,Class<T> type,Object... args){
        /*Connection conn = JDBCUtils.getConnection();
        try {
            return queryRunner.query(conn,sql,new BeanHandler<T>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;*/
            Connection con = JDBCUtils.getConnection();
            try {
                return queryRunner.query(con, sql, new BeanHandler<T>(type), args);
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
    }

    public <T> List<T> queryForList(String sql, Class<T> type, Object... args){
/*        Connection conn = JDBCUtils.getConnection();
        try {
            return queryRunner.query(conn,sql,new BeanListHandler<T>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn);
        }
        return null;*/
        Connection con = JDBCUtils.getConnection();
        try {
            return queryRunner.query(con, sql, new BeanListHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    //返回一列
    public Object queryForSingValue(String sql,Object... args){
/*        Connection conn = JDBCUtils.getConnection();
        try {
           return queryRunner.query(conn,sql,new ScalarHandler(),args);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn);
        }
        return null;
    }*/
        Connection conn = JDBCUtils.getConnection();

        try {
            return queryRunner.query(conn, sql, new ScalarHandler(), args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

}
