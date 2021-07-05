import entities.Major;
import org.junit.Assert;
import org.junit.Test;
import repository.impl.MajorRepositoryImpl;

import javax.persistence.NoResultException;

public class MajorRepositoryImplTest {

    MajorRepositoryImpl mri = new MajorRepositoryImpl();

    @Test
    public void getAllMajorsTest(){
        //then
        Assert.assertNotNull(mri.getAllMajors());
    }

    @Test(expected = IllegalArgumentException.class)
    public void getMajorByIdTest_incorrectValue_0(){

        //given
        int tempId = 0;

        //when
        mri.getMajorById(tempId);

    }

    @Test(expected = IllegalArgumentException.class)
    public void getMajorByIdTest_incorrectValue_10(){

        //given
        int tempId = 10;

        //when
        mri.getMajorById(tempId);

    }

    @Test
    public void getMajorByIdTest_correctValue(){

        //given
        int tempId = 1;

        //when
        Major tempMajor = mri.getMajorById(tempId);

        //then
        Assert.assertEquals(tempMajor.getMajorId(), tempId);

    }

    @Test(expected = NoResultException.class)
    public void getMajorByNameTest_incorrectValue(){

        //given
        String tempName = "Incorrect";

        //then
        mri.getMajorByName(tempName);

    }

    @Test
    public void getMajorByNameTest_correctValue(){

        //given
        String tempName = "Informatyka";

        //when
        Major tempMajor = mri.getMajorByName(tempName);

        //then
        Assert.assertEquals(tempMajor.getMajorName(), tempName);

    }

    @Test
    public void saveMajorTest(){

        //given
        Major tempMajor = new Major ("Test");

        //when
        mri.saveMajor(tempMajor);

        //then
        Assert.assertTrue(true);

    }

    @Test(expected = IllegalArgumentException.class)
    public void deleteMajor_incorrectValue_10(){
        //given
        int tempId = 10;

        //when
        mri.getMajorById(tempId);
    }

    @Test(expected = IllegalArgumentException.class)
    public void deleteMajor_incorrectValue_0(){
        //given
        int tempId = 0;

        //when
        mri.deleteMajor(tempId);
    }


    @Test
    public void deleteMajor_correctValue(){
        //given
        int tempId = 6;

        //when
        mri.deleteMajor(tempId);

        //then
        Assert.assertTrue(true);
    }


    @Test(expected = IllegalArgumentException.class)
    public void getMajorSubjects_incorrectValue_0(){
        //given
        int tempId = 0;

        //when
        mri.getMajorSubjects(tempId);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getMajorSubjects_incorrectValue_10(){
        //given
        int tempId = 10;

        //when
        mri.getMajorSubjects(tempId);
    }


    @Test
    public void getMajorSubjects_correctValue(){
        //given
        int tempId = 1;

        //then
        Assert.assertNotNull(mri.getMajorSubjects(tempId));

    }

    @Test
    public void getMajorSubjects_correctValue_empty(){
        //given
        int tempId = 7;

        //then
        Assert.assertNull(mri.getMajorSubjects(tempId));

    }


}
