/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author Marcus
 */
public class EmployeeDTO {
    private Integer id;
    private String name;
    private String address;

    //Forstår virkelig ikke PUNKT 2 i denne opgave? Hvad skal man returnere?
    //Formuleringen af denne opgaver...

    public EmployeeDTO() {}
    public EmployeeDTO(Integer id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
  
    
    
    
}
