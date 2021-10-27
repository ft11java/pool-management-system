package com.havuzentity.havuzentitty.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.havuzentity.havuzentitty.dto.MaintenancePlanCreateDTO;
import com.havuzentity.havuzentitty.dto.MaintenancePlanUpdateDTO;
import com.havuzentity.havuzentitty.dto.MaintenancePlanUserViewDTO;
import com.havuzentity.havuzentitty.dto.MaintenancePlanAdminViewDTO;
import com.havuzentity.havuzentitty.service.MaintenancePlanService;
import com.havuzentity.havuzentitty.shared.GenericResponse;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MaintenancePlanController {

	private final MaintenancePlanService maintenancePlanService;

	@GetMapping("v1/admin/maintenance-plan/{id}")

	public ResponseEntity<MaintenancePlanAdminViewDTO> getMaintenancePlanGetById(@PathVariable("id") int id) {
		final MaintenancePlanAdminViewDTO maintenancePlan = maintenancePlanService.getMaintenancePlanById(id);

		return ResponseEntity.ok(maintenancePlan);
	}

	@GetMapping("v1/user/maintenance-plan/{id}")

	public ResponseEntity<MaintenancePlanUserViewDTO> getUserMaintenancePlanGetById(@PathVariable("id") int id) {
		final MaintenancePlanUserViewDTO maintenancePlan = maintenancePlanService.getUserMaintenancePlanById(id);

		return ResponseEntity.ok(maintenancePlan);
	}

	@GetMapping("v1/admin/maintenance-plan")
	public ResponseEntity<List<MaintenancePlanAdminViewDTO>> getMaintenancePlan() {
		final List<MaintenancePlanAdminViewDTO> maintennacePlan = maintenancePlanService.getMaintenancePlan();
		return ResponseEntity.ok(maintennacePlan);
	}

	@PostMapping("v1/admin/maintenance-plan")
	public ResponseEntity<?> createMaintenancePlan(
			@Valid @RequestBody MaintenancePlanCreateDTO maintenancePlanCreateDTO) {
		maintenancePlanService.createMaintenancePlan(maintenancePlanCreateDTO);

		return ResponseEntity.ok(new GenericResponse("Maintenance Plan Created..."));
	}

	@PutMapping("v1/admin/maintenance-plan/{id}")
	public ResponseEntity<MaintenancePlanAdminViewDTO> updateMaintenancePlan(@PathVariable("id") int id,
			@RequestBody MaintenancePlanUpdateDTO maintenacePlanUpdateDTO) {
		final MaintenancePlanAdminViewDTO maintenancePlan = maintenancePlanService.updateMaintenancePlan(id,
				maintenacePlanUpdateDTO);

		return ResponseEntity.ok(maintenancePlan);        
	}
	
	@DeleteMapping("v1/admin/maintenance-plan/{id}")
	public ResponseEntity<?> deleteMaintenancePlan(@PathVariable("id")int id){
		maintenancePlanService.deleteMaintenancePlan(id);
	
	return ResponseEntity.ok(new GenericResponse("Maintenance Plan Deleted"));
	}

	
	@GetMapping("v1/admin/maintenance-plan/{maintenacePlanId}/add-maintenance-operation/{maintenanveOperationId}")
	public ResponseEntity<MaintenancePlanAdminViewDTO> addMaintenancePlanToMaintenanceOperation(
			@PathVariable("maintenacePlanId") int maintenancePlanId,
			@PathVariable("maintenanveOperationId") int maintenanceOperationId) {

		final MaintenancePlanAdminViewDTO maintenancePlan = maintenancePlanService
				.addMaintenancePlanToMaintenanceOperatin(maintenancePlanId, maintenanceOperationId);

		return ResponseEntity.ok(maintenancePlan);

	}
	
	@GetMapping("v1/admin/maintenance-plan/{maintenacePlanId}/remove-maintenance-operation/{maintenanveOperationId}")
	public ResponseEntity<MaintenancePlanAdminViewDTO> removeMaintenancePlanToMaintenanceOperation(
			@PathVariable("maintenacePlanId") int maintenancePlanId,
			@PathVariable("maintenanveOperationId") int maintenanceOperationId){
		
		final MaintenancePlanAdminViewDTO maintenancePlan=maintenancePlanService
				.removeMaintenancePlanToMaintenanceOperation(maintenancePlanId,maintenanceOperationId);
		
		return ResponseEntity.ok(maintenancePlan);
		
	}

	
	// slice?page=3&size=7 ----url slice den sonra gelecek kısım 3 kaç sayfada
	// geleceği 7 her sayfada kaç kayıt olacagı
	@GetMapping("v1/admin/maintenance-plan/slice")
	public ResponseEntity<List<MaintenancePlanAdminViewDTO>> maintenancePlanSlice(Pageable pageable) {
		final List<MaintenancePlanAdminViewDTO> maintenancePlan = maintenancePlanService.maintenancePlanSlice(pageable);
		return ResponseEntity.ok(maintenancePlan);
	}

}
