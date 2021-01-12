package simple.example.kataloglaptop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import simple.example.kataloglaptop.model.Laptop;

import java.util.List;

public class DaftarLaptopAdapter extends ArrayAdapter<Laptop> {
    Context context;

    public DaftarLaptopAdapter(@NonNull Context context, @NonNull List<Laptop> objects) {
        super(context, R.layout.row_laptop, objects);
        this.context = context;
    }

    class ViewHolder {
        TextView txTgl;
        TextView txNilai;
        TextView txDeskripsi;
        TextView txModel;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Laptop tr = getItem(position);
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.row_laptop,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.txTgl = convertView.findViewById(R.id.row_tx_tgl_transaksi);
            viewHolder.txDeskripsi = convertView.findViewById(R.id.row_tx_desc_transaksi);
            viewHolder.txNilai = convertView.findViewById(R.id.row_tx_nilai_transaksi);
            viewHolder.txModel = convertView.findViewById(R.id.row_tx_model);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.txTgl.setText(GenericUtility.DATE_FORMAT.format(tr.getTanggal()));
        viewHolder.txDeskripsi.setText(tr.getDeskripsi());
        viewHolder.txModel.setText(tr.getModel());
        if (tr.getJenis().equals(Laptop.ACER)) {
            viewHolder.txNilai.setText(tr.getNilai());
        } else {
            viewHolder.txNilai.setText((tr.getNilai()));
        }
        return convertView;
    }
}

