package com.nulp.bat.travelagency;

import com.nulp.bat.travelagency.dto.RoleDto;
import com.nulp.bat.travelagency.model.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@JsonTest
public class RoleDtoTest {

//    @Test
//    public void testToDto() {
//        RoleDto dto = RoleDto.builder(new Role("Tester").bui);
//        assertEquals(42, dto.getId());
//        assertEqulas("Ivan", dto.getName());
//    }
//
//    @Test
//    public void testToDomain() {
//        Person domain = PersonDto.toDomain(new PersonDto() {{
//            setId(42);
//            setName("Ivan");
//        }};
//        assertEquals(42, domain.getId());
//        assertEqulas("Ivan", domain.getName());
//    }
//
//}
//    @Autowired
//    private JacksonTester<RoleDto> json;
//
//    @Test
//    void testSerializePerson() throws Exception {
//        Role domain = RoleDto.RoleDtoBuilder(new RoleDto() {{
//            setRole("Tester");
//        }};
//        assertThat(this.json.write(dto))
//                .isStrictlyEqualToJson("simple-role.json");
//    }
}