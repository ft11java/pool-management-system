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

import com.havuzentity.havuzentitty.dto.MaintenanceOperationCreateDTO;
import com.havuzentity.havuzentitty.dto.MaintenanceOperationUpdateDTO;
import com.havuzentity.havuzentitty.dto.MaintenanceOperationUserViewDTO;
import com.havuzentity.havuzentitty.dto.MaintenanceOperationAdminViewDTO;

import com.havuzentity.havuzentitty.service.MaintenanceOperationService;
import com.havuzentity.havuzentitty.shared.GenericResponse;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MaintenanceOperationController {
	
	private final MaintenanceOperationService maintenanceOperationService;
	
		@GetMapping("v1/admin/maintenance-operation/{id}")
	public ResponseEntity<MaintenanceOperationAdminViewDTO> getMaintennaceOperationById(@PathVariable("id") int id) {
		final MaintenanceOperationAdminViewDTO maintenanceOperation = maintenanceOperationService.maintenanceOperationById(id);
		return ResponseEntity.ok(maintenanceOperation);
	}
		@GetMapping("v1/user/maintenance-operation/{id}")
		public ResponseEntity<MaintenanceOperationUserViewDTO> getUserMaintennaceOperationById(@PathVariable("id") int id) {
			final MaintenanceOperationUserViewDTO maintenanceOperation = maintenanceOperationService.getUserMaintenanceOperationById(id);
			return ResponseEntity.ok(maintenanceOperation);
		}

	@GetMapping("v1/admin/maintenance-operation")
	public ResponseEntity<List<MaintenanceOperationAdminViewDTO>> getMaintenanceOperation() {
		final List<MaintenanceOperationAdminViewDTO> maintenanceOperation = maintenanceOperationService.getMaintenanceOperation();
		return ResponseEntity.ok(maintenanceOperation);
	}

	@PostMapping("v1/admin/maintenance-operation")
	public ResponseEntity<?> createMaintenanceOperation(
			@Valid @RequestBody MaintenanceOperationCreateDTO maintenanceOperationCreateDTO) {
		maintenanceOperationService.createMaintenanceOperation(maintenanceOperationCreateDTO);

		return ResponseEntity.ok(new GenericResponse("Maintenance Operation Created..."));
	}

	@PutMapping("v1/admin/maintenance-operation/{id}")
	public ResponseEntity<MaintenanceOperationAdminViewDTO> updateMaintenanceOperation(@PathVariable("id") int id,
			@RequestBody MaintenanceOperationUpdateDTO maintenanceOperationUpdateDTO) {
		final MaintenanceOperationAdminViewDTO maintenanceOperation = maintenanceOperationService.updateMAintenmanceOperation(id,
				maintenanceOperationUpdateDTO);
		return ResponseEntity.ok(maintenanceOperation);
	}
	
	
	@DeleteMapping("v1/admin/maintenance-operation/{id}")
	public ResponseEntity<?> deleteMaintenanceOperation(@PathVariable("id") int id) {
		maintenanceOperationService.deleteMaintenanceOperation(id);
		return ResponseEntity.ok(new GenericResponse("Maintetnance Operation Deleted"));
	}

	@GetMapping("v1/admin/maintenance-operation/slice")
	public ResponseEntity<List<MaintenanceOperationAdminViewDTO>> maintenanceOperationslice(Pageable pageable) {

		final List<MaintenanceOperationAdminViewDTO> maintenanceOperation = maintenanceOperationService
				.maintenanceOperationSlice(pageable);
		return ResponseEntity.ok(maintenanceOperation);
	}

	
	

}
