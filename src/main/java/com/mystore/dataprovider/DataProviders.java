package com.mystore.dataprovider;

import com.mystore.utility.NewExcelLibrary;
import org.testng.annotations.DataProvider;

import java.util.HashMap;
import java.util.Map;

public class DataProviders {
    NewExcelLibrary obj = new NewExcelLibrary();
    @DataProvider(name = "credentials")
    public Object[][] getCredentials() {
        int rows = obj.getRowCount("Credentials");
        // total columns
        int column = obj.getColumnCount("Credentials");
        int actRows = rows -1;
        Object[][] data = new Object[actRows][column];
        for (int i = 0; i < actRows; i++) {
            for (int j = 0; j < column; j++) {
                data[i][j] = obj.getCellData("Credentials", j, i+2);
            }
        }
        return data;
    }
    @DataProvider(name = "email")
    public Object[][] getEmail() {
        int rows = obj.getRowCount("Email");
        int column = obj.getColumnCount("Email");
        int actRows = rows -1;
        Object[][] data = new Object[actRows][column];
        for (int i = 0; i < actRows; i++) {
            for (int j = 0; j < column; j++) {
                data[i][j] = obj.getCellData("Email", j, i+2);
            }
        }
        return data;
    }

    @DataProvider(name = "getProduct")
    public Object[][] getProduct() {
        int rows = obj.getRowCount("ProductDetails");
        int column = obj.getColumnCount("ProductDetails");
        int actRows = rows -1;
        Object[][] data = new Object[actRows][column];
        for (int i = 0; i < actRows; i++) {
            for (int j = 0; j < column; j++) {
                data[i][j] = obj.getCellData("ProductDetails", j, i+2);
            }
        }
        return data;
    }
    @DataProvider(name = "searchProduct")
    public Object[][] getProductPrice() {
        int rows = obj.getRowCount("SearchProduct");
        int column = obj.getColumnCount("SearchProduct");
        int actRows = rows -1;
        Object[][] data = new Object[actRows][column];
        for (int i = 0; i < actRows; i++) {
            for (int j = 0; j < column; j++) {
                data[i][j] = obj.getCellData("SearchProduct", j, i+2);
            }
        }
        return data;
    }
    @DataProvider(name = "newAccountDetailsData")
    public Object[][] accountCreation() {
        int rows = obj.getRowCount("AccountCreationData");
        int column = obj.getColumnCount("AccountCreationData");
        int actRows = rows -1;
        Object[][] data = new Object[actRows][1];
      for (int i = 0; i < actRows; i++) {
          Map<String, String> hashMap = new HashMap<>();
          for (int j = 0; j < column; j++) {
              hashMap.put(obj.getCellData("AccountCreationData", j, 1),
                      obj.getCellData("AccountCreationData", j, i+2));
          }
            data[i][0] = hashMap;
      }
        return data;
    }
    @DataProvider(name = "addressData")
    public Object[][] addressData() {
        int rows = obj.getRowCount("AddressData");
        int column = obj.getColumnCount("AddressData");
        int actRows = rows -1;
        Object[][] data = new Object[actRows][1];
        for (int i = 0; i < actRows; i++) {
            Map<String, String> hashMap = new HashMap<>();
            for (int j = 0; j < column; j++) {
                hashMap.put(obj.getCellData("AddressData", j, 1),
                        obj.getCellData("AddressData", j, i+2));
            }
            data[i][0] = hashMap;
        }
        return data;
    }
}
