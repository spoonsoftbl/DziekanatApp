import entities.Lecturer;
import org.junit.Assert;
import org.junit.Test;
import repository.impl.LecturerRepositoryImpl;

public class LecturerRepositoryImplTest {

    LecturerRepositoryImpl lri = new LecturerRepositoryImpl();

    @Test(expected = IllegalArgumentException.class)
    public void getLecturerByIdTest_incorrectValue_99(){

        //given
        int tempId = 99;

        //when
        lri.getLecturerById(tempId);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getLecturerByIdTest_incorrectValue_1000(){

        //given
        int tempId = 1000;

        //when
        lri.getLecturerById(tempId);
    }

    @Test
    public void getLecturerByIdTest_correctValue(){

        //given
        int tempId = 100;

        //when
        Lecturer tempLecturer = lri.getLecturerById(tempId);

        //then
        Assert.assertNotNull(tempLecturer);
    }

    @Test
    public void getLecturerByLastNameTest_incorrectValue(){

        //given
        String tempLastName = "Maddd";

        //when
        Lecturer tempLecturer = lri.getLecturerByLastName(tempLastName);

        //then
        Assert.assertNull(tempLecturer);
    }

    @Test
    public void getLecturerByLastNameTest_correctValue(){

        //given
        String tempLastName = "Liść";

        //when
        Lecturer tempLecturer = lri.getLecturerByLastName(tempLastName);

        //then
        Assert.assertNotNull(tempLecturer);
    }

    @Test
    public void saveLecturerTest(){

        //given
        Lecturer tempLecturer = new Lecturer("Maciej","Małach");

        //when
        Lecturer resultLecturer = lri.saveLecturer(tempLecturer);

        //then
        Assert.assertEquals(resultLecturer, tempLecturer);

    }

    @Test(expected = IllegalArgumentException.class)
    public void deleteLecturerTest_incorrectValue_99(){

        //give
        int tempId = 99;

        //when
        lri.deleteLecturer(tempId);

    }

    @Test(expected = IllegalArgumentException.class)
    public void deleteLecturerTest_incorrectValue_1000(){

        //give
        int tempId = 1000;

        //when
        lri.deleteLecturer(tempId);

    }

    @Test
    public void deleteLecturerTest_correctValue(){

        //give
        int tempId = 114;

        //when
        lri.deleteLecturer(tempId);

        //then
        Assert.assertTrue(true);

    }


}
