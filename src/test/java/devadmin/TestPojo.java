package devadmin;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestPojo {
    public static void main(String[] args)  {
    	try {
		ObjectMapper mapper=new ObjectMapper();
		Pojo pojo = mapper.readValue(new File("src/test/resources/data2.json"), Pojo.class);
		System.out.println("id:"+pojo.getId());
		pojo.setId(12);
		System.out.println("id:"+pojo.getId());
		
		Employee emp = new Employee();
//        emp.setId(102);
//        emp.setName("Ravi");
//        emp.setRole("QA Engineer");
//		
		mapper.writeValue(new File("src/test/resources/data3.json"), pojo);
    }catch(Exception e) {
    	e.printStackTrace();
    }
    }
}
