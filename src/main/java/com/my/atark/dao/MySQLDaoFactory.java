package com.my.atark.dao;

import com.my.atark.dao.implementation.*;
import com.my.atark.exceptions.DataBaseConnectionException;
import com.my.atark.exceptions.IncorrectPropertyException;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MySQLDaoFactory extends DaoFactory {

    private static BasicDataSource basicDataSource;
    private static final Logger log = Logger.getLogger(MySQLDaoFactory.class);
    private Connection connection;

    MySQLDaoFactory() {
        String user = "root";
        String password = "root";
        String host ="localhost";
        String port = "3306";
        String database = "project";
        String useUnicode= "true";
        String encoding= "UTF-8";
        String  url = "jdbc:mysql://" + host + ":" + port + "/" + database + "?useUnicode=" + useUnicode + "&characterEncoding=" + encoding;
        Integer minIdle= 16;
        Integer maxIdle= 32;
        Integer maxActive= 20;
        Integer maxOpenPStatements= 50;

        basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        basicDataSource.setUsername(user);
        basicDataSource.setPassword(password);
        basicDataSource.setUrl(url);
        basicDataSource.setMinIdle(minIdle);
        basicDataSource.setMaxIdle(maxIdle);
        basicDataSource.setMaxActive(maxActive);
        basicDataSource.setMaxOpenPreparedStatements(maxOpenPStatements);
    }

    private static Connection getConnection() throws DataBaseConnectionException {
        try {
            return basicDataSource.getConnection();
        } catch (SQLException sqle) {
            log.error(sqle);
            throw new DataBaseConnectionException();
        }
    }

    /** Transaction methods */
    public void beginTransaction() throws DataBaseConnectionException {
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
        } catch (SQLException sqle) {
            log.error(sqle);
            throw new DataBaseConnectionException();
        }
    }

    public void commitTransaction() throws DataBaseConnectionException {
        try {
            connection.commit();
            connection.close();
        } catch (SQLException sqle) {
            log.error(sqle);
            throw new DataBaseConnectionException();
        }
    }

    public void rollbackTransaction() throws DataBaseConnectionException {
        try {
            connection.rollback();
            connection.close();
        } catch (SQLException sqle) {
            log.error(sqle);
            throw new DataBaseConnectionException();
        }
    }

    /** Connection open and closing methods */
    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException sqle) {
            log.error(sqle);
        }
    }

    @Override
    public void open() throws DataBaseConnectionException {
        connection = getConnection();
    }

    @Override
    public IUserDao getUserDao() {
        return new UserDaoImpl(connection);
    }

    @Override
    public IProductDao getProductDao() {
        return new ProductDaoImpl(connection);
    }

    @Override
    public IInvoiceDao getInvoiceDao() {
        return new InvoiceDaoImpl(connection);
    }

    @Override
    public IPaymentDao getPaymentDao() {
        return new PaymentDaoImpl(connection);
    }

    @Override
    public ITransactionDao getTransactionDao() {
        return new TransactionDaoImpl(connection);
    }
}