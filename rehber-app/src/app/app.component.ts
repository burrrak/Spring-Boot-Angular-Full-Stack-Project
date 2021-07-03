import {Component, OnInit} from '@angular/core';
import {Kisi} from './kisi';
import {HttpClient, HttpErrorResponse} from '@angular/common/http';
import {KisiService} from './kisi.service';
import {NgForm} from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  public kisiler: Kisi[];
  public editKisi: Kisi;
  public deleteKisi: Kisi;


  constructor(private kisiService: KisiService) { }

  // void ekledim
  ngOnInit(): void  {
    this.getKisiler();
  }


  public getKisiler(): void {
    this.kisiService.getKisiler().subscribe(
      (response: Kisi[]) => {
        this.kisiler = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onAddKisi(addForm: NgForm): void {
    document.getElementById('add-kisi-form').click();
    this.kisiService.addKisi(addForm.value).subscribe(
     (response: Kisi ) => {
       console.log(response);
       this.getKisiler();
       addForm.reset();
     },
     (error: HttpErrorResponse ) => {
       alert(error.message);
     },
   );
  }

  public onUpdateKisi(kisi: Kisi): void {
    this.kisiService.updateKisi(kisi).subscribe(
      (response: Kisi ) => {
        console.log(response);
        this.getKisiler();
      },
      (error: HttpErrorResponse ) => {
        alert(error.message);
      },
    );
  }

  public onDeleteKisi(kisiId: number): void {
    this.kisiService.deleteKisi(kisiId).subscribe(
      (response: void ) => {
        console.log(response);
        this.getKisiler();
      },
      (error: HttpErrorResponse ) => {
        alert(error.message);
      },
    );
  }

  public searchKisiler(key: string): void {
    console.log(key);
    const results: Kisi[] = [];
    for (const kisi of this.kisiler) {
      if (kisi.adi.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || kisi.soyadi.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || kisi.email.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || kisi.meslek.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || kisi.telefon.toLowerCase().indexOf(key.toLowerCase()) !== -1) {
        results.push(kisi);
      }
    }
    this.kisiler = results;
    if (results.length === 0 || !key) {
      this.getKisiler();
    }

  }

  public onOpenModal(kisi: Kisi, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button' ;
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addKisiModal');
    }
    if (mode === 'edit') {
      this.editKisi = kisi;
      button.setAttribute('data-target', '#updateKisiModal');
    }
    if (mode === 'delete') {
      this.deleteKisi = kisi;
      button.setAttribute('data-target', '#deleteKisiModal');
    }
    container.appendChild(button);
    button.click();
  }




}
