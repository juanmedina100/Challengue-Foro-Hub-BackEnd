package com.jimd.Security01;

import com.jimd.Security01.persistencia.PermissionEntity;
import com.jimd.Security01.persistencia.RoleEntity;
import com.jimd.Security01.persistencia.RoleEnum;
import com.jimd.Security01.persistencia.UserEntity;
import com.jimd.Security01.persistencia.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class Security01Application {

	public static void main(String[] args) {
		SpringApplication.run(Security01Application.class, args);
	}

//	@Bean
//	CommandLineRunner init(UserRepository userRepository){
//		return args -> {
//			//CREATE PERMISION
//
//			PermissionEntity createPermission = PermissionEntity.builder()
//					.name("CREATE")
//					.build();
//			PermissionEntity readPermission = PermissionEntity.builder()
//					.name("READ")
//					.build();
//			PermissionEntity updatePermission = PermissionEntity.builder()
//					.name("UPDATE")
//					.build();
//			PermissionEntity deletePermission = PermissionEntity.builder()
//					.name("DELETE")
//					.build();
//			PermissionEntity refactorPermission = PermissionEntity.builder()
//					.name("REFACTOR")
//					.build();
//			//Roles
//			RoleEntity roleAdmin = RoleEntity.builder()
//					.reloEnum(RoleEnum.ADMIN)
//					.permissionEntitySet(Set.of(createPermission,readPermission,updatePermission,deletePermission))
//					.build();
//			RoleEntity roleUser = RoleEntity.builder()
//					.reloEnum(RoleEnum.USER)
//					.permissionEntitySet(Set.of(readPermission))
//					.build();
//			RoleEntity roleInvited = RoleEntity.builder()
//					.reloEnum(RoleEnum.INVITED)
//					.permissionEntitySet(Set.of(readPermission))
//					.build();
//			//CREAR USUARIOS
//			UserEntity userSantiago = UserEntity.builder()
//					.username("santiago")
//					.password("1234")
//					.isEnabled(true)
//					.accountNoExpired(true)
//					.accountNoLocked(true)
//					.redentialNoExperid(true)
//					.roles(Set.of(roleAdmin))
//					.build();
//			UserEntity userAndrea = UserEntity.builder()
//					.username("andrea")
//					.password("1234")
//					.isEnabled(true)
//					.accountNoExpired(true)
//					.accountNoLocked(true)
//					.redentialNoExperid(true)
//					.roles(Set.of(roleUser))
//					.build();
//
//			userRepository.saveAll(List.of(userSantiago,userAndrea));
//		};
//	}

}
