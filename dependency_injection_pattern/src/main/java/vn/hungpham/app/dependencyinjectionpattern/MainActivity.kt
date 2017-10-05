package vn.hungpham.app.dependencyinjectionpattern

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import vn.hungpham.app.dependencyinjectionpattern.consumer.Consumer
import vn.hungpham.app.dependencyinjectionpattern.injector.EmailServiceInjector
import vn.hungpham.app.dependencyinjectionpattern.injector.MessageServicceInjector
import vn.hungpham.app.dependencyinjectionpattern.injector.SmsServiceInjector

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val msg = "Hello Di"
        val email = "abc@xyz.com"
        val phone = "123456789"
        var injector: MessageServicceInjector
        var app: Consumer

        //Send email
        injector = EmailServiceInjector()
        app = injector.getConsumer()
        app.processMessage(msg, email)
        //Send SMS
        injector = SmsServiceInjector()
        app = injector.getConsumer()
        app.processMessage(msg, phone)
    }
}
