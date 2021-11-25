package android.ptc.com.ptcflixing.dispatcher

import android.ptc.com.ptcflixing.dispatcher.search.SearchDispatcherImpl
import android.ptc.com.ptcflixing.repository.local.BaseLocalRepo
import android.ptc.com.ptcflixing.repository.remote.search.SearchRemoteRepo
import com.nhaarman.mockitokotlin2.capture
import org.hamcrest.CoreMatchers.*
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentCaptor
import org.mockito.ArgumentCaptor.forClass
import org.mockito.Captor
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner
import java.lang.reflect.Type

@RunWith(MockitoJUnitRunner::class)
class SearchDispatcherTest {
    private lateinit var SUT: BaseDispatcher
    @Mock private lateinit var localRepo: BaseLocalRepo
    @Mock private lateinit var searchRemoteRepo: SearchRemoteRepo

    @Before
    fun setUp() {
//        MockitoAnnotations.initMocks(this)
//        localRepo = Mockito.mock(BaseLocalRepo::class.java)
//        val searchRemoteRepo = Mockito.mock(SearchRemoteRepo::class.java)
        SUT = SearchDispatcherImpl(localRepo, searchRemoteRepo)
        setUpLocal()
    }

    @Captor
    private lateinit var captor: ArgumentCaptor<Type>

    @Test
    fun getCashedObject_success_objectReturned() {
        val result = SUT.getCashedObject(Any::class.java)
        assertThat(result, instanceOf(Any::class.java))
    }


    @Test
    fun savedObject_success_anyTypeObject() {
        //Arrange
        val ac = forClass(Any::class.java)
        val ac2 = forClass(Long::class.java)
        val input = Any()
        //Act
        SUT.saveObject(input, Any::class.java)
        //Assert
        verify(localRepo).saveObject(ac.capture(), capture(captor), capture(ac2))
        assertThat(ac.value, `is`(input))
        assertThat(captor.value, isA(Any::class.java))
    }

    private fun setUpLocal() {
        Mockito.`when`(localRepo.getCashedObject(Any::class.java)).thenReturn(Any())
    }

//    class BaseRemoteRepoTd :SearchRemoteRepo {
//        override suspend fun fetchData(requestFactory: BaseRequestFactory):
//                Response<out BaseModel>? {
//            return null
//        }
//    }
//    class BaseLocalRepoTd:BaseLocalRepo{
//        override fun getCashedObject(type: Type): Any{
//            return Any()
//        }
//        override fun <T> saveObject(instance: T, type: Type, lastModifiedDate: Long) {
//            if(instance==null){
//                throw IllegalArgumentException("Can't be null")
//            }else if(type != instance!!::class.java){
//                throw InvalidParameterException("Invalid types")
//            }
//        }
//    }
}




