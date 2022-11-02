package com.temple.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.temple.exception.ResourceNotFoundException;
import com.temple.model.Temple;
import com.temple.service.TempleService;
import com.temple.util.ExcelExporter;
import com.temple.util.PdfGenereator;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/api")
public class TempleController {

	@Autowired
	private TempleService templeService;

	
	/*******************************************************************************************************
	 - Function Name	:	addTemple(@RequestBody Temple temple)
	 - Input Parameters	:	Temple temple
	 - Return Type		:	ResponseEntity<Temple>
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	adding Temple to database calls service method addTemple(temple)
	 ********************************************************************************************************/
	// ADD
	@PostMapping("/admin/addTemple")
	public ResponseEntity<Temple> addTemple(@RequestBody Temple temple) {
		Temple temple1 = templeService.addTemple(temple);

		log.info("Temple record added successfully");
		return new ResponseEntity<>(temple1, HttpStatus.CREATED);
	}

	
	/*******************************************************************************************************
	 - Function Name	:	deleteTemple(@PathVariable("templeId") Integer templeId)
	 - Input Parameters	:	Integer templeId
	 - Return Type		:	ResponseEntity<HttpStatus>
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	calls service method deleteTemple(templeId)
	 ********************************************************************************************************/
	// DELETE
	@DeleteMapping("/admin/deleteTemple/{templeId}")
	public ResponseEntity<HttpStatus> deleteTemple(@PathVariable("templeId") Integer templeId) {
		templeService.deleteTemple(templeId);

		log.info("Temple record deleted successfully");
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	
	/*******************************************************************************************************
	 - Function Name	:	updateTemple(@PathVariable("templeId") int templeId,@PathVariable("update") String update, @RequestBody Temple temple)
	 - Input Parameters	:	int templeId,String update, Temple temple
	 - Return Type		:	ResponseEntity<Temple>
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	calls service method updateTempleName(templeId, temple), updateTempleHistory(templeId, temple)
	 ********************************************************************************************************/
	// UPDATE
	@PutMapping("/admin/updateTemple/{templeId}/{update}")
	public ResponseEntity<Temple> updateTemple(@PathVariable("templeId") int templeId,
			@PathVariable("update") String update, @RequestBody Temple temple) {

		if (update.equalsIgnoreCase("TempleName")) {
			Temple temple1 = templeService.updateTempleName(templeId, temple);

			log.info("TempleName updated successfully");
			return new ResponseEntity<>(temple1, HttpStatus.OK);
		} else if (update.equalsIgnoreCase("TempleHistory")) {
			Temple temple1 = templeService.updateTempleHistory(templeId, temple);

			log.info("TempleHistory updated successfully");
			return new ResponseEntity<>(temple1, HttpStatus.OK);
		} else {
			log.error("BAD CREDENTIALS");
			throw new ResourceNotFoundException("BAD CREDENTIALS");

		}
	}

	
	/*******************************************************************************************************
	 - Function Name	:	getAllTemples()
	 - Input Parameters	:	
	 - Return Type		:	ResponseEntity<List<Temple>>
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	calls service method getAllTemples()
	 ********************************************************************************************************/
	// ADMIN
	@GetMapping("/admin/retrieveTemples")
	public ResponseEntity<List<Temple>> getAllTemples() {
		List<Temple> temple = templeService.getAllTemples();

		log.info("retrieved all Temple records successfully");
		return new ResponseEntity<>(temple, HttpStatus.OK);
	}

	
	/*******************************************************************************************************
	 - Function Name	:	retrieveTempleById(@PathVariable Integer templeId)
	 - Input Parameters	:	Integer templeId
	 - Return Type		:	ResponseEntity<Temple>
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	calls service method retrieveTempleById(templeId)
	 ********************************************************************************************************/
	@GetMapping("/admin/retrieveTempleById/{templeId}")
	public ResponseEntity<Temple> retrieveTempleById(@PathVariable Integer templeId) {
		Temple temple1 = templeService.retrieveTempleById(templeId);

		log.info("retrieved Temple record by templeId");
		return new ResponseEntity<>(temple1, HttpStatus.OK);
	}

	
	/*******************************************************************************************************
	 - Function Name	:	retrieveTempleByName(@PathVariable String templeName)
	 - Input Parameters	:	String templeName
	 - Return Type		:	ResponseEntity<List<Temple>>
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	calls service method retrieveTempleByName(templeName)
	 ********************************************************************************************************/
	@GetMapping("/admin/retrieveTempleByName/{templeName}")
	public ResponseEntity<List<Temple>> retrieveTempleByName(@PathVariable String templeName) {
		List<Temple> temple1 = templeService.retrieveTempleByName(templeName);

		log.info("retrieved Temple record by templeName");
		return new ResponseEntity<>(temple1, HttpStatus.OK);
	}

	
	/*******************************************************************************************************
	 - Function Name	:	retrieveTemplesByCity(@PathVariable("city") String city)
	 - Input Parameters	:	String city
	 - Return Type		:	ResponseEntity<List<Temple>>
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	calls service method retrieveTemplesByCity(city)
	 ********************************************************************************************************/
	@GetMapping("/admin/retrieveTemplesByCity/{city}")
	public ResponseEntity<List<Temple>> retrieveTemplesByCity(@PathVariable("city") String city) {
		List<Temple> temple = templeService.retrieveTemplesByCity(city);
		
		log.info("retrieved Temple records by city");
		return new ResponseEntity<>(temple, HttpStatus.OK);
	}
	
	
	/*******************************************************************************************************
	 - Function Name	:	retrieveTemplesByArea(@PathVariable("area") String area)
	 - Input Parameters	:	String area
	 - Return Type		:	ResponseEntity<List<Temple>>
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	calls service method retrieveTemplesByArea(area)
	 ********************************************************************************************************/
	@GetMapping("/admin/retrieveTemplesByArea/{area}")
	public ResponseEntity<List<Temple>> retrieveTemplesByArea(@PathVariable("area") String area) {
		List<Temple> temple = templeService.retrieveTemplesByArea(area);
		
		log.info("retrieved Temple records by Area");
		return new ResponseEntity<>(temple, HttpStatus.OK);
	}
	
	
	/*******************************************************************************************************
	 - Function Name	:	retrieveTemplesByState(@PathVariable("state") String state)
	 - Input Parameters	:	String state
	 - Return Type		:	ResponseEntity<List<Temple>>
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	calls service method retrieveTemplesByState(state)
	 ********************************************************************************************************/
	@GetMapping("/admin/retrieveTemplesByState/{state}")
	public ResponseEntity<List<Temple>> retrieveTemplesByState(@PathVariable("state") String state) {
		List<Temple> temple = templeService.retrieveTemplesByState(state);
		
		log.info("retrieved Temple records by State");
		return new ResponseEntity<>(temple, HttpStatus.OK);
	}

	
	/*******************************************************************************************************
	 - Function Name	:	getAllTemplesForUser()
	 - Input Parameters	:	
	 - Return Type		:	ResponseEntity<List<Temple>>
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	calls service method getAllTemples()
	 ********************************************************************************************************/
	// USER
	@GetMapping("/user/retrieveTemples")
	public ResponseEntity<List<Temple>> getAllTemplesForUser() {
		List<Temple> temple = templeService.getAllTemples();

		log.info("retrieved all Temple records successfully");
		return new ResponseEntity<>(temple, HttpStatus.OK);
	}

	
	/*******************************************************************************************************
	 - Function Name	:	retrieveTempleByIdForUser(@PathVariable Integer templeId)
	 - Input Parameters	:	Integer templeId
	 - Return Type		:	ResponseEntity<Temple>
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	calls service method retrieveTempleById(templeId)
	 ********************************************************************************************************/
	@GetMapping("/user/retrieveTempleById/{templeId}")
	public ResponseEntity<Temple> retrieveTempleByIdForUser(@PathVariable Integer templeId) {
		Temple temple1 = templeService.retrieveTempleById(templeId);

		log.info("retrieved Temple record by templeId");
		return new ResponseEntity<>(temple1, HttpStatus.OK);
	}

	
	/*******************************************************************************************************
	 - Function Name	:	retrieveTempleByNameForUser(@PathVariable String templeName)
	 - Input Parameters	:	String templeName
	 - Return Type		:	ResponseEntity<List<Temple>>
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	calls service method retrieveTempleByName(templeName)
	 ********************************************************************************************************/
	@GetMapping("/user/retrieveTempleByName/{templeName}") // :.+
	public ResponseEntity<List<Temple>> retrieveTempleByNameForUser(@PathVariable String templeName) {
		List<Temple> temple1 = templeService.retrieveTempleByName(templeName);

		log.info("retrieved Temple record by templeName");
		return new ResponseEntity<>(temple1, HttpStatus.OK);
	}

	
	/*******************************************************************************************************
	 - Function Name	:	retrieveTemplesByCityForUser(@PathVariable("city") String city)
	 - Input Parameters	:	String city
	 - Return Type		:	ResponseEntity<List<Temple>>
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	calls service method retrieveTemplesByCity(city)
	 ********************************************************************************************************/
	@GetMapping("/user/retrieveTemplesByCity/{city}")
	public ResponseEntity<List<Temple>> retrieveTemplesByCityForUser(@PathVariable("city") String city) {
		List<Temple> temple = templeService.retrieveTemplesByCity(city);
		
		log.info("retrieved Temple records by City");
		return new ResponseEntity<>(temple, HttpStatus.OK);
	}
	
	
	/*******************************************************************************************************
	 - Function Name	:	retrieveTemplesByAreaForUser(@PathVariable("area") String area)
	 - Input Parameters	:	String area
	 - Return Type		:	ResponseEntity<List<Temple>>
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	calls service method retrieveTemplesByArea(area)
	 ********************************************************************************************************/
	@GetMapping("/user/retrieveTemplesByArea/{area}")
	public ResponseEntity<List<Temple>> retrieveTemplesByAreaForUser(@PathVariable("area") String area) {
		List<Temple> temple = templeService.retrieveTemplesByArea(area);
		
		log.info("retrieved Temple records by Area");
		return new ResponseEntity<>(temple, HttpStatus.OK);
	}
	
	
	/*******************************************************************************************************
	 - Function Name	:	retrieveTemplesByStateForUser(@PathVariable("state") String state)
	 - Input Parameters	:	String state
	 - Return Type		:	ResponseEntity<List<Temple>>
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	calls service method retrieveTemplesByState(state)
	 ********************************************************************************************************/
	@GetMapping("/user/retrieveTemplesByState/{state}")
	public ResponseEntity<List<Temple>> retrieveTemplesByStateForUser(@PathVariable("state") String state) {
		List<Temple> temple = templeService.retrieveTemplesByState(state);
		
		log.info("retrieved Temple records by State");
		return new ResponseEntity<>(temple, HttpStatus.OK);
	}
	
	
	/*******************************************************************************************************
	 - Function Name	:	retrieveTemplesByLocation(@PathVariable("state") String state,@PathVariable("city") String city,@PathVariable("area") String area)
	 - Input Parameters	:	String state,String city,String area
	 - Return Type		:	ResponseEntity<List<Temple>>
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	calls service method retrieveTemplesByLocation(state,city,area)
	 ********************************************************************************************************/
	// Retrieve by Location
	@GetMapping("/user/retrieveTemplesByLocation/{state}/{city}/{area}")
	public ResponseEntity<List<Temple>> retrieveTemplesByLocation(@PathVariable("state") String state,
			@PathVariable("city") String city,@PathVariable("area") String area) {
		
		List<Temple> temple = templeService.retrieveTemplesByLocation(state,city,area);
		
		log.info("retrieved Temple records by Location");
		return new ResponseEntity<>(temple, HttpStatus.OK);
	}

    
	/*******************************************************************************************************
	 - Function Name	:	templeDetailsReport(@PathVariable(value = "userRole") String userRole,HttpServletResponse response)
	 - Input Parameters	:	String userRole,HttpServletResponse response
	 - Return Type		:	List<Temple>
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	calls service method getAllTemples()
	 ********************************************************************************************************/
	// PDF Generator
	@GetMapping("/{userRole}/retrieveTemples/pdf")
	public List<Temple> templeDetailsReport(@PathVariable(value = "userRole") String userRole,
			HttpServletResponse response) throws IOException {
		
		if (userRole.equalsIgnoreCase("user") || userRole.equalsIgnoreCase("admin")) {
			DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD:HH:MM:SS");
			String headerKey = "Content-Disposition";
			String headerVal = "attachment; filename=temple_details_" + dateFormat.format(new Date()) + ".pdf";
			response.setHeader(headerKey, headerVal);
			List<Temple> list = templeService.getAllTemples();
			PdfGenereator.templeDetailReport(response, list);
			return list;
		} 
		else {
			log.error("BAD CREDENTIALS");
			throw new ResourceNotFoundException("BAD CREDENTIALS");
		}
	}

	
	/*******************************************************************************************************
	 - Function Name	:	templeDetailsReportById(@PathVariable(value = "userRole") String userRole,@PathVariable(value = "templeId") int templeId,HttpServletResponse response)
	 - Input Parameters	:	String userRole,int templeId,HttpServletResponse response
	 - Return Type		:	Temple
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	calls service method retrieveTempleById(templeId)
	 ********************************************************************************************************/
	// PDF Generator
	@GetMapping("/{userRole}/retrieveTempleById/{templeId}/pdf")
	public Temple templeDetailsReportById(@PathVariable(value = "userRole") String userRole,@PathVariable(value = "templeId") int templeId,
			HttpServletResponse response) throws IOException {
		
		if (userRole.equalsIgnoreCase("user") || userRole.equalsIgnoreCase("admin")) {
			DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD:HH:MM:SS");
			String headerKey = "Content-Disposition";
			String headerVal = "attachment; filename=temple_details_" + dateFormat.format(new Date()) + ".pdf";
			response.setHeader(headerKey, headerVal);
			Temple list = templeService.retrieveTempleById(templeId);
			PdfGenereator.templeDetailReportById(response, list);
			return list;
		} 
		else {
			log.error("BAD CREDENTIALS");
			throw new ResourceNotFoundException("BAD CREDENTIALS");
		}
	}
	
	
	/*******************************************************************************************************
	 - Function Name	:	templeDetailsReportByName(@PathVariable(value = "userRole") String userRole,@PathVariable(value = "templeName") String templeName,HttpServletResponse response)
	 - Input Parameters	:	String userRole,String templeName,HttpServletResponse response
	 - Return Type		:	List<Temple>
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	calls service method retrieveTempleByName(templeName)
	 ********************************************************************************************************/
	//PDF generator 
	@GetMapping("/{userRole}/retrieveTempleByName/{templeName}/pdf")
	public List<Temple> templeDetailsReportByName(@PathVariable(value = "userRole") String userRole,@PathVariable(value = "templeName") String templeName,
			HttpServletResponse response) throws IOException {
		
		if (userRole.equalsIgnoreCase("user") || userRole.equalsIgnoreCase("admin")) {
			DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD:HH:MM:SS");
			String headerKey = "Content-Disposition";
			String headerVal = "attachment; filename=temple_details_" + dateFormat.format(new Date()) + ".pdf";
			response.setHeader(headerKey, headerVal);
			List<Temple> list = templeService.retrieveTempleByName(templeName);
			PdfGenereator.templeDetailReport(response, list);
			return list;
		} 
		else {
			log.error("BAD CREDENTIALS");
			throw new ResourceNotFoundException("BAD CREDENTIALS");
		}
	}
	
	
	/*******************************************************************************************************
	 - Function Name	:	templeDetailsReportByCity(@PathVariable(value = "userRole") String userRole,@PathVariable(value = "city") String city,HttpServletResponse response)
	 - Input Parameters	:	String userRole,String city,HttpServletResponse response
	 - Return Type		:	List<Temple>
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	calls service method retrieveTemplesByCity(city)
	 ********************************************************************************************************/
	//PDF generator 
	@GetMapping("/{userRole}/retrieveTemplesByCity/{city}/pdf")
	public List<Temple> templeDetailsReportByCity(@PathVariable(value = "userRole") String userRole,@PathVariable(value = "city") String city,
		    HttpServletResponse response) throws IOException {
			
		if (userRole.equalsIgnoreCase("user") || userRole.equalsIgnoreCase("admin")) {
			DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD:HH:MM:SS");
			String headerKey = "Content-Disposition";
			String headerVal = "attachment; filename=temple_details_" + dateFormat.format(new Date()) + ".pdf";
			response.setHeader(headerKey, headerVal);
			List<Temple> list = templeService.retrieveTemplesByCity(city);
			PdfGenereator.templeDetailReport(response, list);
			return list;
		} 
		else {
			log.error("BAD CREDENTIALS");
			throw new ResourceNotFoundException("BAD CREDENTIALS");
		}
	}
	
	
	/*******************************************************************************************************
	 - Function Name	:	templeDetailsReportByArea(@PathVariable(value = "userRole") String userRole,@PathVariable(value = "area") String area,HttpServletResponse response)
	 - Input Parameters	:	String userRole,String area,HttpServletResponse response
	 - Return Type		:	List<Temple>
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	calls service method retrieveTemplesByArea(area)
	 ********************************************************************************************************/
	//PDF generator 
	@GetMapping("/{userRole}/retrieveTemplesByArea/{area}/pdf")
	public List<Temple> templeDetailsReportByArea(@PathVariable(value = "userRole") String userRole,@PathVariable(value = "area") String area,
			HttpServletResponse response) throws IOException {
					
		if (userRole.equalsIgnoreCase("user") || userRole.equalsIgnoreCase("admin")) {
			DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD:HH:MM:SS");
			String headerKey = "Content-Disposition";
			String headerVal = "attachment; filename=temple_details_" + dateFormat.format(new Date()) + ".pdf";
			response.setHeader(headerKey, headerVal);
			List<Temple> list = templeService.retrieveTemplesByArea(area);
			PdfGenereator.templeDetailReport(response, list);
			return list;
		} 
		else {
			log.error("BAD CREDENTIALS");
			throw new ResourceNotFoundException("BAD CREDENTIALS");
		}
	}
	
	
	/*******************************************************************************************************
	 - Function Name	:	templeDetailsReportByState(@PathVariable(value = "userRole") String userRole,@PathVariable(value = "state") String state,HttpServletResponse response)
	 - Input Parameters	:	String userRole,String state,HttpServletResponse response
	 - Return Type		:	List<Temple>
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	calls service method retrieveTemplesByState(state)
	 ********************************************************************************************************/
	//PDF generator 
	@GetMapping("/{userRole}/retrieveTemplesByState/{state}/pdf")
	public List<Temple> templeDetailsReportByState(@PathVariable(value = "userRole") String userRole,@PathVariable(value = "state") String state,
			HttpServletResponse response) throws IOException {
						
		if (userRole.equalsIgnoreCase("user") || userRole.equalsIgnoreCase("admin")) {
			DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD:HH:MM:SS");
			String headerKey = "Content-Disposition";
			String headerVal = "attachment; filename=temple_details_" + dateFormat.format(new Date()) + ".pdf";
			response.setHeader(headerKey, headerVal);
			List<Temple> list = templeService.retrieveTemplesByState(state);
			PdfGenereator.templeDetailReport(response, list);
			return list;
		} 
		else {
			log.error("BAD CREDENTIALS");
			throw new ResourceNotFoundException("BAD CREDENTIALS");
		}
	}
	
	
	/*******************************************************************************************************
	 - Function Name	:	templeDetailsReportByLocation(@PathVariable(value = "userRole") String userRole,@PathVariable(value = "state") String state,@PathVariable(value = "city") String city,@PathVariable(value = "area") String area,HttpServletResponse response)
	 - Input Parameters	:	String userRole,String state,String city,String area,HttpServletResponse response
	 - Return Type		:	List<Temple>
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	calls service method retrieveTemplesByLocation(state,city,area)
	 ********************************************************************************************************/
	//PDF generator 
	@GetMapping("/{userRole}/retrieveTemplesByLocation/{state}/{city}/{area}/pdf")
	public List<Temple> templeDetailsReportByLocation(@PathVariable(value = "userRole") String userRole,@PathVariable(value = "state") String state,
				@PathVariable(value = "city") String city,@PathVariable(value = "area") String area,
				HttpServletResponse response) throws IOException {
							
		if (userRole.equalsIgnoreCase("user") || userRole.equalsIgnoreCase("admin")) {
			DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD:HH:MM:SS");
			String headerKey = "Content-Disposition";
			String headerVal = "attachment; filename=temple_details_" + dateFormat.format(new Date()) + ".pdf";
			response.setHeader(headerKey, headerVal);
			List<Temple> list = templeService.retrieveTemplesByLocation(state,city,area);
			PdfGenereator.templeDetailReport(response, list);
			return list;
		} 
		else {
			log.error("BAD CREDENTIALS");
			throw new ResourceNotFoundException("BAD CREDENTIALS");
		}
	}
	
	
	/*******************************************************************************************************
	 - Function Name	:	exportToExcel(HttpServletResponse response)
	 - Input Parameters	:	HttpServletResponse response
	 - Return Type		:	void
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	calls service method getAllTemples()
	 ********************************************************************************************************/
	//EXCEL Generator
	@GetMapping("/admin/retrieveTemples/excel")
    public void exportToExcel(HttpServletResponse response) throws IOException {
		
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
         
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=temple_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);
         
        List<Temple> listUsers = templeService.getAllTemples();
         
        ExcelExporter excelExporter = new ExcelExporter(listUsers);
         
        excelExporter.export(response);    
    }
	
	
	/*******************************************************************************************************
	 - Function Name	:	exportToExcelForUser(HttpServletResponse response)
	 - Input Parameters	:	HttpServletResponse response
	 - Return Type		:	void
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	TEJA SRINIVAS
	 - Description		:	calls service method getAllTemples()
	 ********************************************************************************************************/
	//EXCEL Generator
	@GetMapping("/user/retrieveTemples/excel")
	public void exportToExcelForUser(HttpServletResponse response) throws IOException {
			
	    response.setContentType("application/octet-stream");
	    DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
	    String currentDateTime = dateFormatter.format(new Date());
	         
	    String headerKey = "Content-Disposition";
	    String headerValue = "attachment; filename=temple_" + currentDateTime + ".xlsx";
	    response.setHeader(headerKey, headerValue);
	         
	    List<Temple> listUsers = templeService.getAllTemples();
	         
	    ExcelExporter excelExporter = new ExcelExporter(listUsers);
	         
	    excelExporter.export(response);    
	    }
	
}



















//@PostMapping("/place/{placeId}/addTemple")
//  public ResponseEntity<Temple> createTemple(@PathVariable(value = "placeId") Integer placeId,
//      @RequestBody Temple temple) {
//    Temple temple1 = placeRepository.findById(placeId).map(place -> {
//    	
//    	temple.setPlace(place);
//       return templeService.addTemple(temple);
//    }).orElseThrow(() -> new RuntimeException("hi"));
//    
//    return new ResponseEntity<>(temple1, HttpStatus.CREATED);
//
//}

//@PostMapping("/temple/{placeId}/{devoteeId}/{festivalId}/{ticketId}/{timingId}/{poojaId}/addTemple")
//  public ResponseEntity<Temple> createTemple(@PathVariable(value = "placeId") Integer placeId,@PathVariable(value = "devoteeId") Integer devoteeId,
//      @PathVariable(value = "festivalId") Integer festivalId,@PathVariable(value = "ticketId") Integer ticketId,
//      @PathVariable(value = "timingId") Integer timingId,@PathVariable(value = "poojaId") Integer poojaId,
//      @RequestBody Temple temple) {
//	
//    Place place = placeRepository.findById(placeId).orElseThrow(() -> new RuntimeException("error"));
//    
//    DevoteeFunds devotee = devoteeFundsRepository.findById(devoteeId).orElseThrow(() -> new RuntimeException("error"));
//    Festival festival = festivalRepository.findById(festivalId).orElseThrow(() -> new RuntimeException("error"));
//    TicketDetails ticket = ticketDetailsRepository.findById(ticketId).orElseThrow(() -> new RuntimeException("error"));
//    Timings timing = timingsRepository.findById(timingId).orElseThrow(() -> new RuntimeException("error"));
//    PoojaDetails pooja = poojaDetailsRepository.findById(poojaId).orElseThrow(() -> new RuntimeException("error"));
//    	
//    	temple.setPlace(place);
//    	temple.setDevoteeFunds(devotee);
//    	temple.setFestival(festival);
//    	temple.setTicketDetails(ticket);
//    	temple.setTiming(timing);
//    	temple.setPoojaDetails(pooja);
//    	
//       Temple temple1 =  templeService.addTemple(temple);
//   // }).orElseThrow(() -> new RuntimeException("hi"));
//    
//    return new ResponseEntity<>(temple1, HttpStatus.CREATED);
//
//}

// @PostMapping("/tutorials/{tutorialId}/comments")
//  public ResponseEntity<Comment> createComment(@PathVariable(value = "tutorialId") Long tutorialId,
//      @RequestBody Comment commentRequest) {
//    Comment comment = tutorialRepository.findById(tutorialId).map(tutorial -> {
//      commentRequest.setTutorial(tutorial);
//      return commentRepository.save(commentRequest);
//    }).orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + tutorialId));
//
//    return new ResponseEntity<>(comment, HttpStatus.CREATED);
//  }