package com.example.demo.ctl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.StudentDTO;
import com.example.demo.form.ORSResponse;
import com.example.demo.form.StudentForm;
import com.example.demo.service.StudentServiceInt;



@RestController
@RequestMapping("Student")
public class StudentCtl {
	
	@Autowired
	StudentServiceInt studentService;
	
	
	  @GetMapping("/get/{id}") 
	  public ORSResponse get(@PathVariable("id") Long id){
	  System.out.println("get run");
	  ORSResponse res=  new ORSResponse();
	 
	  HashMap<Long,StudentDTO> data = new HashMap<Long, StudentDTO>(); 
	  System.out.println(id);
	  StudentDTO c = data.get(id); 
	  System.out.println(c);
	  
	  StudentDTO dto = studentService.findByPK(id);
	  if (dto != null) { 
	  res.setSuccess(true);
	  res.addResult("data", dto);
	  
	 } else { 
	 
		 res.setSuccess(false);
		 res.addResult("message", "College not found");
	  
	  } return res; }
	
	
	@PostMapping("/save")
	public ORSResponse get( @RequestBody StudentForm form, BindingResult bindingResult) {
		System.out.println("i am in save of StudentCtl");
		
//		 ORSResponse res= validate(bindingResult);
//
//		if (res.isSuccess() == false) {
//			return res;
//		}
ORSResponse res= new ORSResponse();
		StudentDTO dto = form.getdto();
		
		if (dto != null) {
			res.setSuccess(true);
			long id = dto.getId();
		if(id >0) {
			studentService.update(dto);
			res.addData("Updated Successfully");
		}else{
			
			studentService.add(dto);
			res.addResult("message", "Data addede");
		}
		}else {
			res.setSuccess(false);
			res.addResult("message", "Data is not Added");
		}
		return res;
		
		
		
	}
	
	@RequestMapping(method = { RequestMethod.GET }, value = "/find/{id}")
	public Map get(@PathVariable long id) {
		
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("data", studentService.findByPK(id));
		
		return response;
	}

	
	  @GetMapping("delete/{id}") 
	  public ORSResponse delete(@PathVariable("id") Long id) { 
	  ORSResponse res = new ORSResponse();
	  studentService.delete(id); 
	  res.addResult("message", "Record Deleted Succefully");
	  return res; 
	  }
	 
	  @GetMapping("search") 
	  ORSResponse search( StudentDTO dto) {
		  System.out.println("Search run success");
     ORSResponse res = new ORSResponse();
	  List<StudentDTO>list= studentService.search(dto,1,5); 
	  res.addResult("data", list);
	  return res; 
	  }
	 
	  public ORSResponse validate(BindingResult bindingResult) {
		  ORSResponse res = new ORSResponse();
			System.out.println("inside the validate method of baseCtl");
			if (bindingResult.hasErrors()) {
				
				res.setSuccess(false);

				Map<String, String> errors = new HashMap<String, String>();

				List<FieldError> list = bindingResult.getFieldErrors();
				// Lambda expression Java 8 feature
				list.forEach(e -> {
					errors.put(e.getField(), e.getDefaultMessage());
				});
				res.addInputErrors(errors);
			}
			return res;

		}
}
