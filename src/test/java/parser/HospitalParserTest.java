package parser;

import com.springboot.hello1.domain.Hospital;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HospitalParserTest {


    String line1 = "\"2\",\"의원\",\"01_01_02_P\",\"3620000\",\"PHMA119993620020041100005\",\"199907071\",\"영업/정상\",\"13\",\"영업중\",\"062-574-2802\",\"500867\",\"광주광역시 북구 일곡동 821번지 1호 2층	광주광역시 북구 설죽로 518, 2층 (일곡동)\",\"61041\",\"일곡부부치과의원\",\"2.01709E+13\",\"59:59.0\",\"치과의원\",\"190646.7771\",\"189589.4279\",\"치과의원\",\"2\",\"0\",\"0\",\"200\",\"401\",\"치과\",\"0\",\"0\",\"0\"";

    @Autowired
    ReadLineContext<Hospital> hospitalReadLineContext;

    @Test
    void oneHundreadThousandRows() throws IOException {
        String filename = "C:\\Users\\PC\\Downloads\\fulldata_01_01_02_P_의원.csv";
        List<Hospital> hospitalList = hospitalReadLineContext.readByLine(filename);
        assertTrue(hospitalList.size() > 1000);
        assertTrue(hospitalList.size() > 10000);

        for (int i = 0; i < 10; i++) {
            System.out.println(hospitalList.get(i).getHospitalName());
        }
        System.out.printf("파싱된 데이터 개수:", hospitalList.size());
    }

    @Test
    @DisplayName("csv 1줄을 Hostpital로 잘 만드는지 Test")
    void convertToHospital() {

        HospitalParser hp = new HospitalParser();
        Hospital hospital = hp.parse(line1);

        assertEquals(1, hospital.getId()); //컬럼 넘버 적기
        assertEquals("의원", hospital.getOpenServiceName());
        assertEquals(3620000,hospital.getOpenLocalGovernmentCode());
        assertEquals("PHMA119993620020041100004",hospital.getManagementNumber());
        assertEquals(LocalDateTime.of(1999, 6, 12, 0, 0, 0), hospital.getLisenseDate()); //19990612
        assertEquals(6, hospital.getBusinessStatus());
        assertEquals(13, hospital.getBusinessStatusCode());
        assertEquals("062-515-2875", hospital.getPhone());
        assertEquals("광주광역시 북구 풍향동 565번지 4호 3층", hospital.getFullAddress());
        assertEquals("광주광역시 북구 동문대로 24, 3층 (풍향동)", hospital.getRoadNameAddress());
        assertEquals("효치과의원", hospital.getHospitalName());
        assertEquals("치과의원", hospital.getBusinessTypeName());
        assertEquals(1, hospital.getHealthcareProviderCount());
        assertEquals(0, hospital.getPatientRoomCount());
        assertEquals(0, hospital.getTotalNumberOfBeds());
        assertEquals(52.29f, hospital.getTotalAreaSize());



    }

}