package com.example.bruno_brasil_irisi_meko_comp305_sec003_lab06;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.gson.Gson;
import java.text.DecimalFormat;

public class CartActivity extends AppCompatActivity {

    EditText editTextName;
    EditText editTextEmail;
    EditText editTextPhone;
    TextView textViewShopingCart;
    String itemsPurchased;
    private Cart cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        textViewShopingCart = (TextView) findViewById(R.id.textViewShopingCart);
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPhone = (EditText) findViewById(R.id.editTextPhone);

        Gson gson = new Gson();
        Intent intent = getIntent();
        cart = gson.fromJson(intent.getStringExtra(BookActivity.CART), Cart.class);

        itemsPurchased = "Title                                   Quantity        Price\n\n";
        double totalAmount = 0;

        for (int i = 0; i < cart.shoppingCart.size();i++){

            itemsPurchased += cart.shoppingCart.get(i).getTitle()+ "      "
                    + String.valueOf(cart.shoppingCart.get(i).getQuantity())+"          "
                    + "$" + String.valueOf(cart.shoppingCart.get(i).getPrice()) +"\n\n";

            totalAmount += (cart.shoppingCart.get(i).getQuantity() * cart.shoppingCart.get(i).getPrice());
        }

        DecimalFormat df = new DecimalFormat("###.##");
        itemsPurchased += "\n\nTotal:\t $"+ df.format(totalAmount);
        textViewShopingCart.setText(itemsPurchased);
    }

    public void submitOrder(View view){
        try {
            String message = editTextName.getText()+"," +"\n"+
                    "We are pleased to confirm that your order is now being processed.\n" +
                    "You can track the progress of your order at any time by logging into your account. " +
                    "Below are your order details.\n";

            message +="\n\n"+itemsPurchased;

//            SmsManager smgr = SmsManager.getDefault();
//            smgr.sendTextMessage(editTextPhone.getText().toString(),null,message,null,null);
//            Toast.makeText(getBaseContext(), "SMS Sent Successfully", Toast.LENGTH_SHORT).show();

            Intent it = new Intent(Intent.ACTION_SEND);
            it.putExtra(Intent.EXTRA_EMAIL, new String[]{editTextEmail.getText().toString()});
            it.putExtra(Intent.EXTRA_SUBJECT,"Order Confirmation");
            it.putExtra(Intent.EXTRA_TEXT,message);
            it.setType("message/rfc822");
            startActivity(Intent.createChooser(it,"Choose Mail App"));
        } catch (Exception ex){
            Toast.makeText(getBaseContext(), "Failed to Send SMS/Email, please try again!\n"+ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}