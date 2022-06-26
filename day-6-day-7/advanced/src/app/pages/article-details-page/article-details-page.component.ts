import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-article-details-page',
  templateUrl: './article-details-page.component.html',
  styleUrls: ['./article-details-page.component.css']
})
export class ArticleDetailsPageComponent implements OnInit {

  id;


  // INJECTION SERVICE

  constructor( private route:ActivatedRoute ) { }



  // excute automaticlly once component is on the screen
  ngOnInit(): void {
    console.log(this.route);
    
    this.id = this.route.snapshot.params.id;
  }

}
