import com.nhaarman.mockito_kotlin.verify
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import ru.gb.gb_popular_libs.lession1.CountersModel
import ru.gb.gb_popular_libs.lession1.MainPresenter
import ru.gb.gb_popular_libs.lession1.MainView

class MyTest {

    @Mock
    lateinit var testActivity: MainView

    val counters =  Mockito.mock(CountersModel::class.java);

    @Before
    fun setUp()
    {
        MockitoAnnotations.initMocks(this)

    }

    @Test
    fun testTest() {
        //убедился что тесты работают :)
        Assert.assertEquals(1, 1)
    }

    @Test
    fun testCreateMockActivity(){
        //для себя проверил что testActivity мокнулась :)
        Assert.assertNotNull(testActivity)
    }

    @Test
    fun testCounters(){
        //проверим модель с данным, что она работает корректно
        var counter = CountersModel();
        Assert.assertEquals(1, counter.next(0))
        Assert.assertEquals(1, counter.next(1))
        Assert.assertEquals(1, counter.next(2))

        Assert.assertEquals(2, counter.next(0))
        Assert.assertEquals(3, counter.next(0))
        Assert.assertEquals(4, counter.next(0))

    }

    @Test
    fun testPresenter(){
        //проверим работы презентера уже подсунув ему мокнутые Активити и Модель
        var presenter = MainPresenter(testActivity,counters)

        Mockito.`when`(counters.next(0)).thenReturn(1)
        Mockito.`when`(counters.next(1)).thenReturn(1)
        Mockito.`when`(counters.next(2)).thenReturn(1)



        presenter.counterClick(0)
        verify(testActivity).setButtonText(0,"1")

        presenter.counterClick(1)
        verify(testActivity).setButtonText(1,"1")

        presenter.counterClick(2)
        verify(testActivity).setButtonText(2,"1")

    }



}