package org.example;

import org.example.util.HibernateUtil;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        HibernateUtil.getSessionFactory().openSession();
    }
}
