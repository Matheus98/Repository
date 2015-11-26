package snct.ifpb.edu.br.snct;

import android.app.Notification;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;


public class NotificationOnClickListener implements OnClickListener {
    public void onClick(View v) {
    Context ctx = v.getContext();
    avaliacaoDAO banco = new avaliacaoDAO (ctx);
    int notificationId = 001;

    Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

    Notification notificationBuild = new NotificationCompat.Builder(ctx)
            .setSmallIcon(R.drawable.correto)
            .setContentTitle("Avaliacões")
            .setContentText("O número de avaliações efetuadas é " + banco.buscar()+".")
            .setSound(alarmSound)
            .build();

    NotificationManagerCompat notificationManager = NotificationManagerCompat.from(ctx);


    notificationManager.notify(notificationId, notificationBuild);

}

}
